package com.springmvc.controller;


import com.github.pagehelper.PageHelper;
import com.springmvc.entity.Admin;
import com.springmvc.utils.LeeJSONResult;
import com.springmvc.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/app/index")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/login.action")
    @ResponseBody
    public LeeJSONResult login(String username, String adpsw, HttpSession session) throws Exception {
        Admin admin = new Admin();
        // 下面开始登录认证
        admin.setUsername(username.trim());
        admin.setAdpsw(adpsw.trim());
        admin=adminService.verification(admin);

        if(admin !=null){
            return LeeJSONResult.ok("success");

        }
       else{
           return LeeJSONResult.errorMsg("失败");
        }

    }
}
