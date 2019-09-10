package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.LifeSpend;
import com.springmvc.service.LifeSpendService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/app/lifespend")
public class LifeSpendController {
    @Autowired
    private LifeSpendService lifeSpendService;

    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getLifeSpendAll.action")
    @ResponseBody
    public LeeJSONResult getLifeSpendAll(int page, int limit){
        PageHelper.startPage(page, limit);

        List<LifeSpend> map = lifeSpendService.getLifeSpendAll();
        if(map != null){
            PageInfo<LifeSpend> pageInfo =new PageInfo<LifeSpend>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加客户订单
     * @param lifeSpend
     * @return
     */
    @RequestMapping(value = "/addLifeSpend.action")
    @ResponseBody
    public LeeJSONResult addSpend(LifeSpend lifeSpend){

        boolean lifeSpend1 = lifeSpendService.addSpend(lifeSpend);

        if(lifeSpend1){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param lifeSpend
     * @return
     */
    @RequestMapping(value = "/upLifeSpend.action")
    @ResponseBody
    public LeeJSONResult upLifeSpend(LifeSpend lifeSpend){

        boolean LifeSpend1 = lifeSpendService.update(lifeSpend); //将更新数据传入
        if(LifeSpend1){
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

        boolean FT = lifeSpendService.deleteById(id);
        if(FT){
            List<LifeSpend>map = lifeSpendService.getLifeSpendAll();
            if(map != null){
                PageInfo<LifeSpend> pageInfo =new PageInfo<LifeSpend>(map);
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
    @RequestMapping(value = "/getLifeSpendByInf.action")
    @ResponseBody
    public LeeJSONResult getLifeSpendByInf(  int page,
                                             int limit,
                                             Date spendtime
                                             ){
        PageHelper.startPage(page, limit);

        LifeSpend lifeSpend=new LifeSpend();

        if(spendtime!=null){
            lifeSpend.setSpendtime(spendtime);
        }
        List<LifeSpend> map = lifeSpendService.queryLifeSpendByInf(lifeSpend);
        System.out.println(map);
        if(map != null){
            PageInfo<LifeSpend> pageInfo =new PageInfo<LifeSpend>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
}
