package com.hm.travel.controller;

import com.hm.travel.pojo.Account;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.AccountService;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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


    /**
     * 完善用户信息
     * @param user 表单提交的User
     * @return 受影响行数
     */
    @RequestMapping("/improveUserInfo")
    @ResponseBody
    public String improveUserInfo(UserInfo user,HttpServletRequest request) {
         userService.addUser(user);
        UserInfo userInfo = userService.seleceUserByName(user.getUserName());
        Account account = accountService.selectAccountById((int) request.getSession().getAttribute("ACCOUNTID"));
       if(null != userInfo){
           account.setUserInfo(userInfo);
           int i = accountService.improveAccount(account);
           if(i>0){
               return "成功";
           }else{
               return "保存至账号信息时失败";
           }
       }else{
           return "没有取到用户信息";
       }

    }

    /**
     * 创建账号
     * @param account 表单提交的Account
     * @return 受影响行数
     */
    @RequestMapping("/createAccount")
    public String CreateAccount(Account account) {
        int i = accountService.addAccount(account);
        if (i > 0) {
            return "redirect:/login.html";
        } else {
            return "redirect:/registered.html";
        }
    }

    /**
     * 普通用户登录
     * @param account 表单提交的账号信息
     * @param request request对象,用于获取Session,将登录成功的用户账号ID存入Session域中
     * @return 数据库中查询该账号,为null即没查到,反之验证通过
     */
    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest request) {
        Account account1 = accountService.selectAccount(account);
        System.out.println("反回对象"+account1);
        if (null != account1) {
            Integer account1Id = account1.getId();
            request.getSession().setAttribute("ACCOUNTID",account1Id);
            return "index";
        }else{
            return "redirect:/404.html";
        }
    }
}
