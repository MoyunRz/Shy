package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.ClientInf;
import com.springmvc.entity.ClientOrder;
import com.springmvc.service.ClientInfService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app/clientinf")
public class ClientInfController {
    @Autowired
    private ClientInfService clientInfService;
    /**
     * 查询所有用户
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getClientInfAll.action")
    @ResponseBody
    public LeeJSONResult getClientOrderAll(int page, int limit){
        PageHelper.startPage(page, limit);
        List<ClientInf> map = clientInfService.getClientInfAll();
        System.out.println(map);
        if(map != null){
            PageInfo<ClientInf> pageInfo =new PageInfo<ClientInf>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

    /**
     *  添加客户订单
     * @param clientInf
     * @return
     */
    @RequestMapping(value = "/addClientInf.action")
    @ResponseBody
    public LeeJSONResult addClientInf(ClientInf clientInf){

        ClientInf clientInf1 = clientInfService.insert(clientInf);

        if(clientInf1 !=null){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param clientInf
     * @return
     */
    @RequestMapping(value = "/upClientInf.action")
    @ResponseBody
    public LeeJSONResult upClientInf(ClientInf clientInf){

        boolean clientOrder1 = clientInfService.update(clientInf); //将更新数据传入
        if(clientOrder1){
            return LeeJSONResult.ok("更新成功");
        }else{
            return LeeJSONResult.errorMsg("更新失败");
        }
    }
    /**
     * 用过ID删除客户
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById.action")
    @ResponseBody
    public LeeJSONResult deleteById(String id){
        System.out.println(id);
        boolean FT = clientInfService.deleteById(id);
        if(FT){
            return LeeJSONResult.ok("success");
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
    @RequestMapping(value = "/getClientInfByInf.action")
    @ResponseBody
    public LeeJSONResult getClientInfByInf(int page,
                                           int limit,
                                           String cname){



        PageHelper.startPage(page, limit);
        ClientInf clientInf=new ClientInf();
        if(cname !=null){
            clientInf.setCname(cname.trim());
        }
        List<ClientInf> map = clientInfService.queryClientInfByInf(clientInf);
        System.out.println(map);
        if(map != null){
            PageInfo<ClientInf> pageInfo =new PageInfo<ClientInf>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

    @RequestMapping(value = "/getClientCount.action")
    @ResponseBody
    public LeeJSONResult getClientCount(){

        int count =clientInfService.CountAll();

        if( count>0){
            return LeeJSONResult.ok(count);

        }else{
            return LeeJSONResult.errorMsg("无数据");
        }
    }

    @RequestMapping(value = "/getClientAll.action")
    @ResponseBody
    public LeeJSONResult getClientAll() {

        List<ClientInf> map = clientInfService.getClientInfAll();

        if (map != null) {
            return LeeJSONResult.ok(map);
        } else {
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

}
