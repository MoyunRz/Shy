package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.ClientOrder;
import com.springmvc.service.ClientOrderService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app/clientorder")
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;

    /**
     * 查询所有订单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getClientOrderAll.action")
    @ResponseBody
    public LeeJSONResult getClientOrderAll(int page, int limit){
        PageHelper.startPage(page, limit);
    
        List<ClientOrder>map = clientOrderService.getClientOrderAll();
        if(map != null){
            PageInfo<ClientOrder> pageInfo =new PageInfo<ClientOrder>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加客户订单
     * @param clientOrder
     * @return
     */
    @RequestMapping(value = "/addClientOrder.action")
    @ResponseBody
    public LeeJSONResult addClientOrder(ClientOrder clientOrder){

        ClientOrder clientOrder1 = clientOrderService.insert(clientOrder);

        if(clientOrder1 !=null){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param clientOrder
     * @return
     */
    @RequestMapping(value = "/upClientOrder.action")
    @ResponseBody
    public LeeJSONResult upClientOrder(ClientOrder clientOrder){
        System.out.println(clientOrder.getTotal());
        boolean clientOrder1 = clientOrderService.update(clientOrder); //将更新数据传入
        if(clientOrder1){
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
    @RequestMapping(value = "/OrderdeleteById.action")
    @ResponseBody
    public LeeJSONResult OrderdeleteById(int page, int limit,String oid){
        PageHelper.startPage(page, limit);

        boolean FT = clientOrderService.OrderdeleteById(oid);
        if(FT){
            List<ClientOrder>map = clientOrderService.getClientOrderAll();
            if(map != null){
                PageInfo<ClientOrder> pageInfo =new PageInfo<ClientOrder>(map);
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
    @RequestMapping(value = "/getClientOrderByInf.action")
    @ResponseBody
    public LeeJSONResult getClientOrderByInf(int page,
                                             int limit,
                                             String cname,
                                             Date odate,
                                             int ostatus){



        PageHelper.startPage(page, limit);
        ClientOrder clientOrder=new ClientOrder();
       if(cname !=null&&cname !=""){
           clientOrder.setCname(cname.trim());
       }
       if(odate !=null){
           clientOrder.setOdate(odate);
       }
      if(ostatus>=0){
          clientOrder.setOstatus(ostatus);
      }

        List<ClientOrder> map = clientOrderService.queryClientOrderByInf(clientOrder);
        System.out.println(map);
        if(map != null){
            PageInfo<ClientOrder> pageInfo =new PageInfo<ClientOrder>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());

        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
}
