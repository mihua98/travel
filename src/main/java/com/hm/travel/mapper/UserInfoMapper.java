package com.hm.travel.mapper;

import com.hm.travel.pojo.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author jlz
 * @date 2019/8/20 16:13
 */
@Repository
public interface UserInfoMapper {
    /**
     * 根据ID查询用户信息
     * @param id 用户ID
     * @return 用户
     */
    @Select("select * from userInfo where id = #{id}")
    UserInfo selectUserById(Integer id);

    /**
     * 查询用户总数
     * @return
     */
    @Select("select count(1) from account ")
    int getUserInfoNum();

    /**
     * 根据精确姓名查询用户
     * @param userName
     * @return 该用户
     */
    @Select("select * from userInfo where user_name = #{userName}")
    UserInfo seleceUserByName(String userName);

    /**
     * 根据email查询
     * @param email
     * @return
     */
    @Select("select * from userInfo where email = #{email}")
     UserInfo selectUserByEmail(String email);

    /**
     * 根据姓名模糊查询用户
     * @param userName
     * @return 该用户
     */
    @Select("select * from userInfo where user_name like '%#{userName}%'")
    List<UserInfo> seleceUserLikeName(String userName);
    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    @Select("select * from userInfo")
    List<UserInfo> getAllUser();

    /**
     * 根据ID删除用户
     *
     * @return 受影响行数
     */
    @Delete("delete from UserInfo where id = #{id}")
    int deleteUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param userInfo 更新后的用户
     * @return 受影响行数
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 添加用户
     *
     * @param userInfo 用户
     * @return 受影响行数
     */
    int addUser(UserInfo userInfo);


}
