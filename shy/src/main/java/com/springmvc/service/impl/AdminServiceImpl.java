package com.springmvc.service.impl;

import com.springmvc.entity.Admin;
import com.springmvc.mapper.AdminMapper;
import com.springmvc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin verification(Admin admin) {
        return adminMapper.selectByNameAndPsw(admin);
    }
}
