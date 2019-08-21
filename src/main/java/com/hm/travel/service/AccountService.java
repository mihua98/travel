package com.hm.travel.service;

import com.hm.travel.pojo.Account;


/**
 * @author jlz
 * @date 2019/8/21 13:47
 */
public interface AccountService {
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
     * @param password      新密码
     * @return 受影响行数
     */

    int updateAccount(String password);

    /**
     * 删除账号根据ID
     * @param id  用户ID
     * @return 受影响行数
     */

    int deleteAccountById(Integer id);
}
