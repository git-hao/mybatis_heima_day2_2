import com.hao.dao.UserDao;
import com.hao.dao.impl.UserDaoImpl;
import com.hao.domain.QueryVo;
import com.hao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Describe com.hao.dao
 * @Auther wenhao chen
 * @CreateDate 2019/8/28
 * @Version 1.0
 * xml配置，注解，两种测试
 */
public class UserDaoTest {

    private InputStream in;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用工厂，创建dao对象
        userDao = new UserDaoImpl(factory);
    }
    @After
    public void destory()throws Exception{
        in.close();
    }
    @Test
    public void testFindAll(){
        //执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("wandou222");
        user.setBirthday(new Date());
        user.setSex("woman");
        System.out.println("保存之前："+user);
        userDao.saveUser(user);
        System.out.println("保存之后："+user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(9);
        user.setUsername("jizi");
        user.setBirthday(new Date());
        user.setSex("woman");
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(9);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(2);
        System.out.println(user);
    }
    @Test//模糊查询
    public void testFindByName(){
        List<User> users = userDao.findByName("%a%");
//        List<User> users = userDao.findByName("a");//模糊查询第二种方式

        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testTotal(){
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
    /**
     * 测试使用vo，实体类中包含其他实体类
     */
    @Test
    public void testVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%a%");
        vo.setUser(user);
        List<User> uVo = userDao.findByVo(vo);
        for(User user1 : uVo){
            System.out.println(user1);
        }
    }

}
