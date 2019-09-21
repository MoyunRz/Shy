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
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
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
     *
     * @param page  页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getClientOrderAll.action")
    @ResponseBody
    public LeeJSONResult getClientOrderAll(int page, int limit) {
        PageHelper.startPage(page, limit);

        List<ClientOrder> map = clientOrderService.getClientOrderAll();
        if (map != null) {
            PageInfo<ClientOrder> pageInfo = new PageInfo<ClientOrder>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(), pageInfo.getList());
        } else {
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

    /**
     * 添加客户订单
     *
     * @param clientOrder
     * @return
     */
    @RequestMapping(value = "/addClientOrder.action")
    @ResponseBody
    public LeeJSONResult addClientOrder(ClientOrder clientOrder) {

        ClientOrder clientOrder1 = clientOrderService.insert(clientOrder);

        if (clientOrder1 != null) {
            return LeeJSONResult.ok("添加成功");
        } else {
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     *
     * @param clientOrder
     * @return
     */
    @RequestMapping(value = "/upClientOrder.action")
    @ResponseBody
    public LeeJSONResult upClientOrder(ClientOrder clientOrder) {
        System.out.println(clientOrder.getTotal());
        boolean clientOrder1 = clientOrderService.update(clientOrder); //将更新数据传入
        if (clientOrder1) {
            return LeeJSONResult.ok("更新成功");
        } else {
            return LeeJSONResult.errorMsg("更新失败");
        }
    }

    /**
     * 用过ID删除客户订单
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/OrderdeleteById.action")
    @ResponseBody
    public LeeJSONResult OrderdeleteById(int page, int limit, String oid) {
        PageHelper.startPage(page, limit);

        boolean FT = clientOrderService.OrderdeleteById(oid);
        if (FT) {
            List<ClientOrder> map = clientOrderService.getClientOrderAll();
            if (map != null) {
                PageInfo<ClientOrder> pageInfo = new PageInfo<ClientOrder>(map);
                return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(), pageInfo.getList());
            } else {
                return LeeJSONResult.ok(new HashMap<>());
            }
        } else {
            return LeeJSONResult.errorMsg("删除失败");
        }
    }

    /**
     * 查询所有订单
     *
     * @param page  页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getClientOrderByInf.action")
    @ResponseBody
    public LeeJSONResult getClientOrderByInf(int page,
                                             int limit,
                                             String cname,
                                             Date odate,
                                             int ostatus) {

        PageHelper.startPage(page, limit);
        ClientOrder clientOrder = new ClientOrder();
        if (cname != null && cname != "") {
            clientOrder.setCname(cname.trim());
        }
        if (odate != null) {
            clientOrder.setOdate(odate);
        }
        if (ostatus >= 0) {
            clientOrder.setOstatus(ostatus);
        }

        List<ClientOrder> map = clientOrderService.queryClientOrderByInf(clientOrder);
        System.out.println(map);
        if (map != null) {
            PageInfo<ClientOrder> pageInfo = new PageInfo<ClientOrder>(map);

            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(), pageInfo.getList());

        } else {
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

    /**
     * 统计每个月已结算的销售额
     *
     * @return
     */
    @RequestMapping(value = "/getMonthlyPerformance.action")
    @ResponseBody
    public LeeJSONResult getMonthlyPerformance(int tYear, int tmonth) {
        Double performance = 0.0;
        Double noperformance = 0.0;
        Double allperformance = 0.0;
        List<ClientOrder> map = clientOrderService.getClientOrderAll();
        for (ClientOrder orders : map) {
            if (orders.getOstatus() == 3) {
                if ((orders.getOdate().getYear() + 1900) == tYear && (orders.getOdate().getMonth() + 1) == tmonth) {
                    performance += Double.parseDouble(orders.getTotal().toString());
                }
            } else {

                if ((orders.getOdate().getYear() + 1900) == tYear && (orders.getOdate().getMonth() + 1) == tmonth) {
                    noperformance += Double.parseDouble(orders.getTotal().toString());
                }
                allperformance += Double.parseDouble(orders.getTotal().toString());
            }
        }
        Map<String, Double> num = new HashMap<String, Double>(2);
        num.put("performance", performance);
        num.put("noperformance", noperformance);
        num.put("allperformance", allperformance);
        return LeeJSONResult.ok(num);

    }

    /**
     * 统计每个月的销售额
     *
     * @return
     */
    @RequestMapping(value = "/getYearlyPerformance.action")
    @ResponseBody
    public LeeJSONResult getYearlyPerformance(int tYear) {

        Map<String, Double> performance = new HashMap<String, Double>(12);
        for (int i = 1; i <= 12; i++) {
            performance.put(String.valueOf(i), 0.0);
        }
        List<ClientOrder> map = clientOrderService.getClientOrderAll();
        for (ClientOrder order : map) {
            if ((order.getOdate().getYear() + 1900) == tYear) {
                int month = order.getOdate().getMonth() + 1;
                Double value = performance.get(String.valueOf(month));
                performance.put(String.valueOf(month), value + Double.parseDouble(order.getTotal().toString()));
            }
        }
        return LeeJSONResult.ok(performance);
    }
}