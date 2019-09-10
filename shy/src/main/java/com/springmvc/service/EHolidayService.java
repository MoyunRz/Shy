package com.springmvc.service;

import com.springmvc.entity.EHoliday;

import java.util.List;

public interface EHolidayService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EHoliday> queryAllByLimit(int offset, int limit);

    /**
     *  获取全部材料订单
     * @return
     */
    List<EHoliday> getEHolidayAll();

    /**
     * 根据条件查询订单
     * @param eHoliday
     * @return
     */
    List<EHoliday> queryEHolidayByInf(EHoliday eHoliday);

    /**
     * 新增数据
     * @param eHoliday 实例对象
     * @return 实例对象
     */
    boolean addEHoliday(EHoliday eHoliday);

    /**
     * 修改数据
     * @param eHoliday 实例对象
     * @return 实例对象
     */
    boolean update(EHoliday eHoliday);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
