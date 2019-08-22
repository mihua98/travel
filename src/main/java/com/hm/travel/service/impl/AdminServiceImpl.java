package com.hm.travel.service.impl;

import com.hm.travel.mapper.AdminMapper;
import com.hm.travel.pojo.Admin;
import com.hm.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/22 21:33
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
   @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin AdminLogin(Admin admin) {
        return adminMapper.AdminLogin(admin);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }

    @Override
    public int deleteAdminById(Integer id) {
        return adminMapper.deleteAdminById(id);
    }

    @Override
    public int updateAdminById(String password, Integer id) {
        return adminMapper.updateAdminById(password,id);
    }
}
