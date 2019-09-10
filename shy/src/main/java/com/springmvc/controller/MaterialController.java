package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.ClientOrder;
import com.springmvc.entity.Material;
import com.springmvc.service.MaterialService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/app/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;
    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getMaterialAll.action")
    @ResponseBody
    public LeeJSONResult getMaterialAll(int page, int limit){
        PageHelper.startPage(page, limit);

        List<Material> map = materialService.getMaterialAll();
        if(map != null){
            PageInfo<Material> pageInfo =new PageInfo<Material>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加客户订单
     * @param material
     * @return
     */
    @RequestMapping(value = "/addMaterial.action")
    @ResponseBody
    public LeeJSONResult addMaterial(Material material){


        boolean material1 = materialService.addMaterial(material);

        if(material1){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param material
     * @return
     */
    @RequestMapping(value = "/upMaterial.action")
    @ResponseBody
    public LeeJSONResult upMaterial(Material material){
        System.out.println(material.getTotal());
        boolean material1 = materialService.update(material); //将更新数据传入
        if(material1){
            return LeeJSONResult.ok("更新成功");
        }else{
            return LeeJSONResult.errorMsg("更新失败");
        }
    }
    /**
     * 用过ID删除客户订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById.action")
    @ResponseBody
    public LeeJSONResult deleteById(int page, int limit,String id){
        PageHelper.startPage(page, limit);
        boolean FT = materialService.deleteById(id);
        if(FT){
            List<Material>map = materialService.getMaterialAll();
            if(map != null){
                PageInfo<Material> pageInfo =new PageInfo<Material>(map);
                return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
            }else{
                return LeeJSONResult.ok(new HashMap<>());
            }
        }else{
            return LeeJSONResult.errorMsg("删除失败");
        }
    }

    /**
     * 查询订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getMaterialByInf.action")
    @ResponseBody
    public LeeJSONResult getMaterialByInf(   int page,
                                             int limit,
                                             String mname,
                                             Date mSdate,
                                             int mstatus){
        System.out.println(mname+mSdate+mstatus);
        PageHelper.startPage(page, limit);
        Material material=new Material();
        if(mname !=null&&mname !=""){
            material.setMname(mname.trim());
        }
        if(mSdate !=null){
            material.setMdate(mSdate);
        }
        if(mstatus>=0){
            material.setMstatus(mstatus);
        }
        List<Material> map = materialService.queryMaterialByInf(material);
        System.out.println(map);
        if(map != null){
            PageInfo<Material> pageInfo =new PageInfo<Material>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

}
