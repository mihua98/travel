package com.hm.travel.service.impl;

import com.hm.travel.mapper.AccountMapper;
import com.hm.travel.pojo.Account;
import com.hm.travel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jlz
 * @date 2019/8/21 13:50
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 注册时查询账号ID
     *
     * @param account
     * @return
     */
    @Override
    public Account getAccountId(Account account) {
        return accountMapper.getAccountId(account);
    }

    @Override
    public int updateUserPassword(String password, String email) {
        return accountMapper.updateUserPassword(password, email);
    }

    @Override
    public Account selectAccountById(Integer id) {
        return accountMapper.selectAccountById(id);
    }

    @Override
    public int improveAccount(Account account) {
        return accountMapper.improveAccount(account);
    }

    @Override
    public Account selectAccount(Account account) {
        System.out.println("impl:" + account);
        return accountMapper.selectAccount(account);
    }

    @Override
    public int addAccount(Account account) {
        return accountMapper.addAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccountById(Integer id) {
        return accountMapper.deleteAccountById(id);
    }
}
