package com.springmvc.service.impl;

import com.springmvc.entity.Employees;
import com.springmvc.mapper.EmployessMapper;
import com.springmvc.service.EmployeesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Resource
    EmployessMapper employessMapper;
    @Override
    public List<Employees> queryAllByLimit(int offset, int limit) {
        return this.employessMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public List<Employees> getEmployeesAll() {
        return this.employessMapper.queryEmployeesAll();
    }

    @Override
    public List<Employees> queryEmployeesByInf(Employees employees) {
        return this.employessMapper.queryEmployeesByInf(employees);
    }

    @Override
    public boolean addEmployees(Employees employees) {
        return this.employessMapper.addEmployees(employees)>0;
    }

    @Override
    public boolean update(Employees employees) {
        return this.employessMapper.update(employees)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.employessMapper.deleteById(id)>0;
    }
}
