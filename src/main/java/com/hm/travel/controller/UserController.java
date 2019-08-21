package com.hm.travel.controller;

import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jlz
 * @date 2019/8/21 9:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registered")
    public String registeredUser(UserInfo user) {
        int i = userService.addUser(user);
        System.out.println(i);
        if (i > 0) {
            return "redirect:/login.html";
        } else {
            return "redirect:/registered.html";
        }
    }
}
