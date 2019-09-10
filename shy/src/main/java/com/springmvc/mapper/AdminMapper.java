package com.springmvc.mapper;

import com.springmvc.entity.Admin;
public interface AdminMapper {

    Admin selectByNameAndPsw(Admin admin);

}