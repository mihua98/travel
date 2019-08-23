package com.hm.travel.mapper;

import com.hm.travel.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author jlz
 * @date 2019/8/20 16:55
 */
@Repository
public interface AccountMapper {
    /**
     * * 查询用户账号密码是否正确,
     *
     * @return 返回account不为null即正确
     */
    Account selectAccount(Account account);

    /**
     * 根据账号ID查询账号信息
     * @param id
     * @return
     */
    Account selectAccountById(Integer id);

    /**
     * 添加用户账号
     *
     * @param account
     * @return 受影响行数
     */
    @Insert("insert into account(account_number,password,email)" +
             " values(#{accountNumber},#{password},#{email})")
    int addAccount(Account account);

    /**
     * 用户更改密码
     *
     * @param account 账号
     * @return 受影响行数
     */
    @Update("update account set password = #{password} where id = #{id}")
    int updateAccount(Account account);

    /**
     * 完善账号信息,即更改UserInfoId字段
     * @param account 账号
     * @return 受影响行数
     */
    int improveAccount(Account account);

    /**
     * 用户更改密码
     * @param password
     * @param id
     * @return
     */
    @Update("update account set password = #{password} where email = #{email}")
    int updateUserPassword(String password,String email);
    /**
     * 删除账号根据ID
     *
     * @param id 用户ID
     * @return 受影响行数
     */
    @Delete("delete from account where id = #{id}")
    int deleteAccountById(Integer id);
}
