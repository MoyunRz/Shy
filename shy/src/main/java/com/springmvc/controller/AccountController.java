package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Account;
import com.springmvc.service.AccountService;
import com.springmvc.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/app/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询所有工资单
     * @param page 页码
     * @param limit 页条数
     * @return
     */
    @RequestMapping(value = "/getAccountAll.action")
    @ResponseBody
    public LeeJSONResult getAccountAll(int page, int limit){

        PageHelper.startPage(page, limit);
        List<Account> map = accountService.getAccountAll();

        if(map != null){
            PageInfo<Account> pageInfo =new PageInfo<Account>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }
    /**
     *  添加员工
     * @param account
     * @return
     */
    @RequestMapping(value = "/addAccount.action")
    @ResponseBody
    public LeeJSONResult addAccount(Account account){

        boolean Account1 = accountService.addAccount(account);

        if(Account1){
            return LeeJSONResult.ok("添加成功");
        }else{
            return LeeJSONResult.errorMsg("添加失败");
        }
    }

    /**
     * 更新数据
     * @param account
     * @return
     */
    @RequestMapping(value = "/upAccount.action")
    @ResponseBody
    public LeeJSONResult upAccount(Account account){

        boolean Account1 = accountService.update(account); //将更新数据传入
        if(Account1){
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

        boolean FT = accountService.deleteById(id);
        if(FT){
            List<Account>map = accountService.getAccountAll();
            if(map.size() >0 &&map!=null){
                PageInfo<Account> pageInfo =new PageInfo<Account>(map);
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
    @RequestMapping(value = "/getAccountByInf.action")
    @ResponseBody
    public LeeJSONResult getAccountByInf(  int page,
                                           int limit,
                                           String ename,
                                           int wstatus){
        PageHelper.startPage(page, limit);

        Account account=new Account();

        if(ename!=null&&!ename.equals("")){
            account.setEname(ename);
        }if(wstatus>=0){
            account.setWstatus(wstatus);
        }
        List<Account> map = accountService.queryAccountByInf(account);
        if(map.size()>0){
            PageInfo<Account> pageInfo =new PageInfo<Account>(map);
            return LeeJSONResult.pageBuild(0, (int) pageInfo.getTotal(),pageInfo.getList());
        }else{
            return LeeJSONResult.ok(new HashMap<>());
        }
    }

}
