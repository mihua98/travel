package com.hm.travel.controller;

import com.hm.travel.pojo.Admin;
import com.hm.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
     * 查询所有管理员账号
     * @return
     */
    @RequestMapping("/getAllAdmin")
    @ResponseBody
    public List<Admin> selectAdmin(){
        List<Admin> admins = adminService.getAllAdmin();
        return admins;
    }

    /**
     * 根据ID删除管理员账号
     * @param id
     * @return
     */
    @RequestMapping("/deleteAdmin/{id}")
    @ResponseBody
    public String deleteAdminById(@PathVariable Integer id){
        int i = adminService.deleteAdminById(id);
        if(i>0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    /**
     * 登录的管理员修改自己的密码
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateAdminById(String password,HttpServletRequest request){
        Admin admin = (Admin)request.getSession().getAttribute("ADMIN");
        Integer id = admin.getId();
        int i = adminService.updateAdminById(password, id);
        if (i>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
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
