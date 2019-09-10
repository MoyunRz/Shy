package com.springmvc.mapper;

import com.springmvc.entity.Employees;
import com.springmvc.entity.LifeSpend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployessMapper {

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    List<Employees> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Employees> queryEmployeesAll();

    List<Employees> queryEmployeesByInf(Employees employees);

    int addEmployees(Employees employees);

    int update(Employees employees);

    int deleteById(String id);
}
