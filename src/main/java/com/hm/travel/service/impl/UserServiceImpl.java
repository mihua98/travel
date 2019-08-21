package com.hm.travel.service.impl;

import com.hm.travel.mapper.UserInfoMapper;
import com.hm.travel.pojo.UserInfo;
import com.hm.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/21 9:17
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.addUser(userInfo);
    }

    @Override
    public UserInfo selectUserById(Integer id) {
        return userInfoMapper.selectUserById(id);
    }

    @Override
    public List<UserInfo> getAllUser() {
        return userInfoMapper.getAllUser();
    }

    @Override
    public int deleteUserById(Integer id) {
        return userInfoMapper.deleteUserById(id);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }
}
