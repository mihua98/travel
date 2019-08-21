package com.hm.travel.service;


import com.hm.travel.pojo.UserInfo;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/21 9:13
 */
public interface UserService {
    /**
     * 添加用户
     * @param userInfo 用户
     * @return  受影响行数
     */
    int addUser(UserInfo userInfo);

    /**
     * 根据ID查询用户信息
     * @param id 用户ID
     * @return  用户
     */
    UserInfo selectUserById(Integer id);

    /**
     * 查询所有用户
     * @return  用户集合
     */
    List<UserInfo> getAllUser();

    /**
     * 根据ID删除用户
     * @return 受影响行数
     */
    int deleteUserById(Integer id);

    /**
     * 更新用户信息
     * @param userInfo  更新后的用户
     * @return  受影响行数
     */
    int updateUserInfo(UserInfo userInfo);

}
