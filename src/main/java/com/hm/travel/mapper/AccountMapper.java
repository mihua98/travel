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
     * 添加用户账号
     *
     * @param account
     * @return 受影响行数
     */
    @Insert("insert account(account_number,password) values(#{accountNumber},#{password})")
    int addAccount(Account account);

    /**
     * 用户更改密码
     *
     * @param password 新密码
     * @return 受影响行数
     */
    @Update("update account set password = #{password}")
    int updateAccount(String password);

    /**
     * 删除账号根据ID
     *
     * @param id 用户ID
     * @return 受影响行数
     */
    @Delete("delete from account where id = #{id}")
    int deleteAccountById(Integer id);
}
