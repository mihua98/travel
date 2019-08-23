package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.Account;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.AccountService;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @return 用户集合
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageInfo<UserInfo> getAllUser(@RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "7") int size) throws IOException {
        PageHelper.startPage(start, size, "id desc");
        List<UserInfo> list = userService.getAllUser();
        PageInfo<UserInfo> page = new PageInfo<>(list);
        return page;
    }


    @RequestMapping("/getUserInfoNum")
    @ResponseBody
    public int getUserInfoNum(){
        int userInfoNum = userService.getUserInfoNum();
        return userInfoNum;
    }

    /**
     * 根据ID删除用户
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteUserById(@PathVariable Integer id){
        int i = userService.deleteUserById(id);
        if(i>0){
            return "删除成功";
        }else{
            return "删除失败";
        }

    }

    /**
     * 根据姓名模糊查询ID
     * @param userName 姓名
     * @return 用户
     */
    @RequestMapping("/selectUserLikeName")
    @ResponseBody
    public List<UserInfo> selectUserLikeName( String userName){
        System.out.println(userName);
        List<UserInfo> userInfos = userService.seleceUserLikeName(userName);

        return userInfos;
    }

    /**
     * 根据ID查询用户
     * 管理员修改用户信息前查询用户
     * @param id 用户ID
     * @return 用户
     */
    @RequestMapping("/selectUserById/{id}")
    @ResponseBody
    public UserInfo selectUserById(@PathVariable Integer id){
        UserInfo userInfo = userService.selectUserById(id);
        return userInfo;
    }

    /**
     * 更新修改用户信息
     * @param userInfo 用户修改之后表单提交的信息
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(UserInfo userInfo){
        int i = userService.updateUserInfo(userInfo);
        if(i>0){
            return "修改成功";
        }else{
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
     * 用户注册账号
     * @param account 表单提交的Account
     * @return 受影响行数
     */
    @RequestMapping("/createAccount")
    public String CreateAccount(Account account,UserInfo userInfo) {
        int i = accountService.addAccount(account);
        System.out.println(userInfo);
        int j = userService.addUser(userInfo);
        System.out.println(j);
        if (i > 0) {
            // TODO: 2019/8/23 页面 页面 页面
            return "redirect:/pages/all-admin-login.html";
        } else {
            //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return "redirect:/registered.html";
        }
    }

    /**
     * 用户登录
     * @param account 表单提交的账号信息
     * @param request request对象,用于获取Session,将登录成功的用户账号ID存入Session域中
     * @return 数据库中查询该账号,为null即没查到,反之验证通过
     */
    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest request) {
        Account account1 = accountService.selectAccount(account);
        System.out.println("反回对象"+account1);
        if (null != account1) {
            request.getSession().setAttribute("USER",account1.getUserInfo());
            return "userPage/index";
        }else{
            // TODO: 2019/8/22 404!!!!!!!!!!!!!!!!!!!
            return "redirect:/404.html";
        }
    }

    /**
     * 跳转到用户列表页面
     * @return
     */
    @RequestMapping("/userListPage")
    public String userListPage(){
        System.out.println("跳转页面");
        return "adminPage/userListPage";
    }
}
