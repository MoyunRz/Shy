package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Employees;
import com.springmvc.service.EmployeesService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/app/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getEmployeesAll.action")
    @ResponseBody
    public LeeJSONResult getEmployeesAll(int page, int limit){

        PageHelper.startPage(page, limit);
        List<Employees> map = employeesService.getEmployeesAll();
        if(map != null){
            PageInfo<Employees> pageInfo =new PageInfo<Employees>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加员工
     * @param employees
     * @return
     */
    @RequestMapping(value = "/addEmployees.action")
    @ResponseBody
    public LeeJSONResult addEmployees(Employees employees){

        boolean Employees1 = employeesService.addEmployees(employees);

        if(Employees1){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param employees
     * @return
     */
    @RequestMapping(value = "/upEmployees.action")
    @ResponseBody
    public LeeJSONResult upEmployees(Employees employees){

        boolean Employees1 = employeesService.update(employees); //将更新数据传入
        if(Employees1){
            return LeeJSONResult.ok("更新成功");
        }else{
            return LeeJSONResult.errorMsg("更新失败");
        }
    }
    /**
     * 用过ID删除客户订单
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteById.action")
    @ResponseBody
    public LeeJSONResult deleteById(int page, int limit,int id){
        PageHelper.startPage(page, limit);

        boolean FT = employeesService.deleteById(id+"");
        if(FT){
            List<Employees>map = employeesService.getEmployeesAll();
            if(map != null){
                PageInfo<Employees> pageInfo =new PageInfo<Employees>(map);
                return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
            }else{
                return LeeJSONResult.ok(new HashMap<>());
            }
        }else{
            return LeeJSONResult.errorMsg("删除失败");
        }
    }

    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getEmployeesByInf.action")
    @ResponseBody
    public LeeJSONResult getEmployeesByInf(  int page,
                                             int limit,
                                             String ename){
        PageHelper.startPage(page, limit);

        Employees employees=new Employees();

        if(ename!=null){
            employees.setEname(ename);
        }
        List<Employees> map = employeesService.queryEmployeesByInf(employees);
        System.out.println(map);
        if(map != null){
            PageInfo<Employees> pageInfo =new PageInfo<Employees>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

}
