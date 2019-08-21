package com.hm.travel.controller;

import com.hm.travel.pojo.Account;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.AccountService;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jlz
 * @date 2019/8/21 9:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;



    @RequestMapping("/registered")
    public String registeredUser(UserInfo user) {
        int i = userService.addUser(user);
        System.out.println(i);
        if (i > 0) {
            return "redirect:/createAccount.html";
        } else {
            return "redirect:/registered.html";
        }
    }


    @RequestMapping("/createAccount")
    public String CreateAccount(Account account) {
        int i = accountService.addAccount(account);
        if (i > 0) {
            return "redirect:/login.html";
        } else {
            return "redirect:/registered.html";
        }
    }

    @RequestMapping("/login")
    public String login(Account account) {
        System.out.println(account);
        Account account1 = accountService.selectAccount(account);
        System.out.println("反回对象"+account1);
        if (null != account) {
            return "redirect:/index.html";
        }else{
            return "forward:/error";
        }
    }
    @RequestMapping("/error")
    @ResponseBody
    public String loginSuccess(){
        return "账号密码错误";
    }
}
