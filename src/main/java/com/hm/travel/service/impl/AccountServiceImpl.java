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
        System.out.println("impl:"+account);
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
