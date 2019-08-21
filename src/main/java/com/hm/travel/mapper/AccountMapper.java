package com.hm.travel.mapper;

import com.hm.travel.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jlz
 * @date 2019/8/20 16:55
 */
public interface AccountMapper {
    /**
     * * 查询用户账号密码是否正确,
     *
     * @param accountnumber 账号
     * @param password      密码
     * @return 返回account不为null即正确
     */
    @Select("select * from acount where accountnumber = #{accountnumber} and password = #{password}")
    Account selectAccount(String accountnumber, String password);

    /**
     * 添加用户账号
     *
     * @param account
     * @return 受影响行数
     */
    @Insert("insert account(accountnumber,password,userInfoid) values(#{accountnumber},#{password},#{userInfoid})")
    int addAccount(Account account);

    /**
     * 用户更改密码
     *
     * @param password 新密码
     * @return 受影响行数
     */
    @Update("update account set password = #{password}")
    int updateAccount(String password);
}
