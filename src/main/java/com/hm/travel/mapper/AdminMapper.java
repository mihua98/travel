package com.hm.travel.mapper;

import com.hm.travel.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/22 21:15
 */
@Repository
public interface AdminMapper {
    /**
     * 查询所有管理员账号
     * @return 管理员账号集合
     */
    @Select("select * from admin")
    List<Admin> getAllAdmin();

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Select("select * from admin where account_number = #{accountNumber} and password = #{password}")
    Admin AdminLogin(Admin admin);
    /**
     * 根据ID删除管理员账号
     * @param id
     * @return
     */
    @Delete("delete from admin where id = #{id}")
    int deleteAdminById(Integer id);

    /**
     * 根据ID修改管理员账号密码
     * @param password 新密码
     * @param id 要修改的账号ID
     * @return
     */
    @Update("update admin set password = #{password} where id = #{id}")
    int updateAdminById(String password,Integer id);


    /**
     * 添加管理员账号
     * @param admin 管理员账号
     * @return
     */
    @Insert("insert into admin(account_number,password) values(#{accountNumber},#{password})")
    int addAdmin(Admin admin);
}
