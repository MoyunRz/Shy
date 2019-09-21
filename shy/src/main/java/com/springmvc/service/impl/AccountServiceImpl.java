package com.springmvc.service.impl;

import com.springmvc.entity.Account;
import com.springmvc.mapper.AccountMapper;
import com.springmvc.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> queryAllByLimit(int offset, int limit) {
        return this.accountMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Account> getAccountAll() {
        return this.accountMapper.queryAccountAll();
    }

    @Override
    public List<Account> queryAccountByInf(Account account) {
        return this.accountMapper.queryAccountByInf(account);
    }

    @Override
    public boolean addAccount(Account account) {
        return this.accountMapper.insert(account)>0;
    }

    @Override
    public boolean update(Account account) {
        return this.accountMapper.update(account)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.accountMapper.deleteById(id)>0;
    }
}
