package com.hm.travel.service;

import com.hm.travel.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/22 21:33
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin AdminLogin(Admin admin);
    /**
     * 添加管理员账号
     * @param admin 管理员账号
     * @return
     */
    int addAdmin(Admin admin);
    /**
     * 查询所有管理员账号
     * @return 管理员账号集合
     */
    List<Admin> getAllAdmin();

    /**
     * 根据ID删除管理员账号
     * @param id
     * @return
     */
    int deleteAdminById(Integer id);

    /**
     * 根据ID修改管理员账号密码
     * @param password 新密码
     * @param id 要修改的账号ID
     * @return
     */
    int updateAdminById(String password,Integer id);
}
