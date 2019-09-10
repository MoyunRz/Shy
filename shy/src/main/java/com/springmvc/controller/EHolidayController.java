package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.springmvc.entity.EHoliday;
import com.springmvc.service.EHolidayService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/app/eholiday")
public class EHolidayController {
    @Autowired
    private EHolidayService eHolidayService;

    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getEHolidayAll.action")
    @ResponseBody
    public LeeJSONResult getEHolidayAll(int page, int limit){

        PageHelper.startPage(page, limit);
        List<EHoliday> map = eHolidayService.queryAllByLimit(page,limit);
        if(map != null){
            PageInfo<EHoliday> pageInfo =new PageInfo<EHoliday>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加
     * @param eHoliday
     * @return
     */
    @RequestMapping(value = "/addEHoliday.action")
    @ResponseBody
    public LeeJSONResult addEHoliday(EHoliday eHoliday){

        boolean eHoliday1 = eHolidayService.addEHoliday(eHoliday);

        if(eHoliday1){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param EHoliday
     * @return
     */
    @RequestMapping(value = "/upEHoliday.action")
    @ResponseBody
    public LeeJSONResult upEHoliday(EHoliday EHoliday){

        boolean eHoliday1 = eHolidayService.update(EHoliday); //将更新数据传入
        if(eHoliday1){
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
    public LeeJSONResult deleteById(int page, int limit,String id){
        PageHelper.startPage(page, limit);

        boolean FT = eHolidayService.deleteById(id);
        if(FT){
            List<EHoliday>map = eHolidayService.getEHolidayAll();
            if(map != null){
                PageInfo<EHoliday> pageInfo =new PageInfo<EHoliday>(map);
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
    @RequestMapping(value = "/getEHolidayByInf.action")
    @ResponseBody
    public LeeJSONResult getEHolidayByInf(  int page,
                                           int limit,
                                           String ename
    ){
        PageHelper.startPage(page, limit);

        EHoliday EHoliday=new EHoliday();

        if(ename!=null){
            EHoliday.setEname(ename);
        }
        List<EHoliday> map = eHolidayService.queryEHolidayByInf(EHoliday);
        System.out.println(map);
        if(map != null){
            PageInfo<EHoliday> pageInfo =new PageInfo<EHoliday>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

}
