package com.springmvc.service;

import com.springmvc.entity.LifeSpend;

import java.util.List;

public interface LifeSpendService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LifeSpend> queryAllByLimit(int offset, int limit);

    /**
     *  获取全部材料订单
     * @return
     */
    List<LifeSpend> getLifeSpendAll();

    /**
     * 根据条件查询订单
     * @param lifeSpend
     * @return
     */
    List<LifeSpend> queryLifeSpendByInf(LifeSpend lifeSpend);

    /**
     * 新增数据
     * @param lifeSpend 实例对象
     * @return 实例对象
     */
    boolean addSpend(LifeSpend lifeSpend);

    /**
     * 修改数据
     * @param lifeSpend 实例对象
     * @return 实例对象
     */
    boolean update(LifeSpend lifeSpend);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
