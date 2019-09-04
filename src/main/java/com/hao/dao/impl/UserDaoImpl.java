package com.hao.dao.impl;

import com.hao.dao.UserDao;
import com.hao.domain.QueryVo;
import com.hao.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Describe com.hao.dao.impl
 * @Auther wenhao chen
 * @CreateDate 2019/9/3
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> findAll() {
        //1,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2,获取查询结果,参数：类名.方法名（即xml中：namespace+id）
        List<User> users = sqlSession.selectList("com.hao.dao.UserDao.findAll");
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.hao.dao.UserDao.saveUser",user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("com.hao.dao.UserDao.updateUser",user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.hao.dao.UserDao.deleteUser",id);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public User findById(Integer id) {
        //1,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2,获取查询结果,参数：类名.方法名（即xml中：namespace+id）
        User user = sqlSession.selectOne("com.hao.dao.UserDao.findById",id);
        sqlSession.close();
        return user;
    }

    public List<User> findByName(String name) {
        //1,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2,获取查询结果,参数：类名.方法名（即xml中：namespace+id）
        List<User> users = sqlSession.selectList("com.hao.dao.UserDao.findByName",name);
        sqlSession.close();
        return users;
    }

    public Integer findTotal() {
        //1,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2,获取查询结果,参数：类名.方法名（即xml中：namespace+id）
        Integer count = sqlSession.selectOne("com.hao.dao.UserDao.findTotal");
        sqlSession.close();
        return count;
    }
    public List<User> findByVo(QueryVo vo){
        //1,获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2,获取查询结果,参数：类名.方法名（即xml中：namespace+id）
        List<User> users = sqlSession.selectList("com.hao.dao.UserDao.findByVo",vo);
        sqlSession.close();
        return users;
    }
}
