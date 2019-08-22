package com.hm.travel.controller;

import com.hm.travel.pojo.Admin;
import com.hm.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jlz
 * @date 2019/8/22 21:14
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 添加管理员账号
     * @param admin
     * @return
     */
    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin){
        int i = adminService.addAdmin(admin);
        if(i>0){
            return "添加成功";
        }
        return "添加失败";
    }

    /**
     * 管理员登录
     * @param admin
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String AdminLogin(Admin admin, HttpServletRequest request){
        Admin admin1 = adminService.AdminLogin(admin);
        if (null != admin1) {
            request.getSession().setAttribute("ADMIN",admin1);
            return "all-admin-index";
        }else{
            // TODO: 2019/8/22  !!!!!!!!!!!!!!!!!!!!!
            return "redirect:/404.html";
        }
    }
}
