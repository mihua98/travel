package com.xiaomikasa.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomikasa.springbootdemo.bean.User;
import com.xiaomikasa.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author: 陈敏华
 * @date: 2019/8/15
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public PageInfo<User> findAll(@RequestParam(value = "start", defaultValue = "0") int start,
                                  @RequestParam(value = "size", defaultValue = "5") int size) throws IOException {
        PageHelper.startPage(start, size, "id desc");
        List<User> list = userService.findAll();
        PageInfo<User> page = new PageInfo<>(list);
        return page;
    }

    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }
}
