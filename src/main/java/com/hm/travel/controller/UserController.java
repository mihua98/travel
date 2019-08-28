package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.config.MD5Config;
import com.hm.travel.pojo.Account;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.AccountService;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
     * 查询所有用户信息
     *
     * @return 用户集合
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageInfo<UserInfo> getAllUser(@RequestParam(value = "start", defaultValue = "1") int start,
                                         @RequestParam(value = "size", defaultValue = "4") int size) throws IOException {
        PageHelper.startPage(start, size, "id desc");
        List<UserInfo> list = userService.getAllUser();
        PageInfo<UserInfo> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 得到总用户数量
     *
     * @return
     */
    @RequestMapping("/getUserInfoNum")
    @ResponseBody
    public int getUserInfoNum() {
        int userInfoNum = userService.getUserInfoNum();
        return userInfoNum;
    }

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteUserById(@RequestParam("id") Integer id) {
        int i = userService.deleteUserById(id);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }

    }

    /**
     * 根据姓名模糊查询ID
     *
     * @param userName 姓名
     * @return 用户
     */
    @RequestMapping("/selectUserLikeName")
    @ResponseBody
    public PageInfo<UserInfo> selectUserLikeName(@RequestParam(value = "start", defaultValue = "1") int start,
                                             @RequestParam(value = "size", defaultValue = "4") int size,
                                             @RequestParam("userName")    String userName) {
        System.out.println(userName);
        PageHelper.startPage(start, size, "id desc");
        List<UserInfo> list = userService.seleceUserLikeName(userName);
        PageInfo<UserInfo> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 根据ID查询用户
     * 管理员修改用户信息前查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @RequestMapping("/selectUserById")
    @ResponseBody
    public UserInfo selectUserById(@RequestParam("id") Integer id) {
        UserInfo userInfo = userService.selectUserById(id);
        return userInfo;
    }

    /**
     * 更新修改用户信息
     *
     * @param userInfo 用户修改之后表单提交的信息
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        int i = userService.updateUserInfo(userInfo);

        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

//    /**!!!!!!!此方法可以不调用,当前登录的用户的信息已存在Session中 Attribute("USER")
//     *
//     * 用户修改自身信息前查询自身数据库中的数据(即点击修改信息则调用)
//     * @param request
//     * @return 用户修改前数据库中的信息
//     */
//    @RequestMapping("/UserUpdate")
//    @ResponseBody
//    public UserInfo selectUserByEmail(HttpServletRequest request){
//        UserInfo userInfo = userService.selectUserByEmail(((Account) request.getSession().getAttribute("USER")).getEmail());
//        return userInfo;
//    }

    /**
     * 修改密码
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/updateUserPassword")
    @ResponseBody
    public String updateUserPassword(String password, HttpServletRequest request) {
        UserInfo user = (UserInfo) request.getSession().getAttribute("USER");
        String email = user.getEmail();

        int i = accountService.updateUserPassword(password, email);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 用户注册账号
     *
     * @param account 表单提交的Account
     * @return 受影响行数
     */
    @RequestMapping("/createAccount")
    public String CreateAccount(Account account) {
        String md5Code = MD5Config.getMD5Code(account.getPassword());
        account.setPassword(md5Code);
        int i = accountService.addAccount(account);
        Account account1 = accountService.getAccountId(account);
        System.out.println(account1);
        //这里原来的写法有问题,改了,再把userInfo表的主键自增关了 @author:cmh
        UserInfo userInfo = new UserInfo();
        userInfo.setId(account1.getId());
        userService.addUser(userInfo);
        if (i > 0) {
            return "redirect:/login.html";
        } else {
            //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return "redirect:/register.html";
        }
    }

    /**
     * 用户登录
     *
     * @param account 表单提交的账号信息
     * @param request request对象,用于获取Session,将登录成功的用户账号ID存入Session域中
     * @return 数据库中查询该账号, 为null即没查到, 反之验证通过
     */
    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest request) {
        String md5Code = MD5Config.getMD5Code(account.getPassword());
        account.setPassword(md5Code);
        Account account1 = accountService.selectAccount(account);
        System.out.println("反回对象" + account1);
        if (null != account1) {
            request.getSession().setAttribute("USER", account1.getUserInfo());
           return "userPage/index";
           // return "adminPage/all-admin-index";
        } else {
            // TODO: 2019/8/22 404!!!!!!!!!!!!!!!!!!!
            return "redirect:/404.html";
        }
    }


}
