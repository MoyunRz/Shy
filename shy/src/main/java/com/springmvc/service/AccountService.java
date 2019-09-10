package com.springmvc.service;

import com.springmvc.entity.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Account> queryAllByLimit(int offset, int limit);

    /**
     * 获取全部材料订单
     *
     * @return
     */
    List<Account> getAccountAll();

    /**
     * 根据条件查询订单
     *
     * @param account
     * @return
     */
    List<Account> queryAccountByInf(Account account);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    boolean addAccount(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    boolean update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}