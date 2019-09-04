package com.hao.dao;

import com.hao.domain.QueryVo;
import com.hao.domain.User;

import java.util.List;

/**
 * @Describe com.hao.dao
 * @Auther wenhao chen
 * @CreateDate 2019/8/28
 * @Version 1.0
 *
 */
public interface UserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer id);
    List<User> findByName(String name);
    Integer findTotal();
    List<User> findByVo(QueryVo vo);
}
