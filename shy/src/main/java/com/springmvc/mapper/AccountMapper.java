package com.springmvc.mapper;

import com.springmvc.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Account> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询全部用户订单信息
     * @return
     */
    List<Account> queryAccountAll();

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int update(Account account);

    /**
     *  通过主键删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     *  指定定信息查询
     * @param account
     * @return
     */
    List<Account> queryAccountByInf(Account account);
}
