package com.springmvc.service;

import com.springmvc.entity.Employees;

import java.util.List;

public interface EmployeesService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employees> queryAllByLimit(int offset, int limit);

    /**
     *  获取全部材料订单
     * @return
     */
    List<Employees> getEmployeesAll();

    /**
     * 根据条件查询订单
     * @param employees
     * @return
     */
    List<Employees> queryEmployeesByInf(Employees employees);

    /**
     * 新增数据
     * @param employees 实例对象
     * @return 实例对象
     */
    boolean addEmployees(Employees employees);

    /**
     * 修改数据
     * @param employees 实例对象
     * @return 实例对象
     */
    boolean update(Employees employees);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
