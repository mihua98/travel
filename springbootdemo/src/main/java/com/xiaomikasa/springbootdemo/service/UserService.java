package com.xiaomikasa.springbootdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaomikasa.springbootdemo.bean.User;

import java.io.IOException;
import java.util.List;

/**
 * @author: 陈敏华
 * @date: 2019/8/15
 */
public interface UserService {
    List<User> findAll() throws IOException;

    User findById(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void deleteById(Integer id);
}
