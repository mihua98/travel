package com.xiaomikasa.springbootdemo.dao;

import com.xiaomikasa.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 陈敏华
 * @date: 2019/8/15
 */
@Repository
public interface UserDao {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void addUser(User user);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);
}
