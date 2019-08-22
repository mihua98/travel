package com.hm.travel.controller;

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
    public List<UserInfo> getAllUser(){
       return userService.getAllUser();
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
    public String selectUserLikeName( String userName,Map<String,Object> map){
        System.out.println(userName);
        UserInfo userInfo = userService.seleceUserLikeName(userName);
        map.put("userInfo",userInfo);
        return "likeSelectUser";
    }

    /**
     * 根据ID查询用户
     * 管理员修改用户信息前查询用户
     * @param id 用户ID
     * @return 用户
     */
    @RequestMapping("/selectUserById/{id}")
    public String selectUserById(@PathVariable Integer id,Map<String,Object> map){

        UserInfo userInfo = userService.selectUserById(id);
        map.put("userInfo",userInfo);
        return "improveUserInfo";
    }

    /**
     * 更新修改用户信息
     * @param userInfo
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

    /**
     * 用户修改自身信息前查询自身数据库中的数据(即点击修改信息则调用)
     * @param request
     * @return 用户修改页面
     */
    @RequestMapping("/UserUpdate")
    public String selectUserByEmail(HttpServletRequest request, Map<String,Object> map){
        UserInfo userInfo = userService.selectUserByEmail((String) request.getSession().getAttribute("EMAIL"));
        map.put("userInfo",userInfo);
        return "improveUserInfo";
    }

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
            return "redirect:/pages/all-admin-login.html";
        } else {
            //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return "redirect:/plugins/registered.html";
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
            String email = account1.getEmail();
            request.getSession().setAttribute("EMAIL",email);
            return "all-admin-index";
        }else{
            // TODO: 2019/8/22 404!!!!!!!!!!!!!!!!!!!
            return "redirect:/404.html";
        }
    }
}
