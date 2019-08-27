package com.hm.travel.service;

import com.hm.travel.pojo.Account;


/**
 * @author jlz
 * @date 2019/8/21 13:47
 */
public interface AccountService {

    /**
     * 注册时查询账号ID
     * @param account
     * @return
     */
    Account getAccountId(Account account);


    /**
     * 用户更改密码
     * @param password
     * @param id
     * @return
     */
    int updateUserPassword(String password,String email);
    /**
     * 根据账号ID查询账号信息
     * @param id
     * @return
     */
    Account selectAccountById(Integer id);

    /**
     * 完善账号信息,即更改UserInfoId字段
     * @param account 账号
     * @return 受影响行数
     */
    int improveAccount(Account account);
    /**
     * * 查询用户账号密码是否正确,
     * @return 返回account不为null即正确
     */

    Account selectAccount(Account account);

    /**
     * 添加用户账号
     * @param account
     * @return 受影响行数
     */

    int addAccount(Account account);

    /**
     * 用户更改密码
     * @param account 账号
     * @return 受影响行数
     */

    int updateAccount(Account account);

    /**
     * 删除账号根据ID
     * @param id  用户ID
     * @return 受影响行数
     */

    int deleteAccountById(Integer id);
}
