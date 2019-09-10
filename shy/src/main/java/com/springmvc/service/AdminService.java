package com.springmvc.service;

import com.springmvc.entity.Admin;

public interface AdminService {

    /**
     * 验证用户账号和密码是否正确
     * @param admin
     * @return
     */
    public Admin verification(Admin admin);
}
