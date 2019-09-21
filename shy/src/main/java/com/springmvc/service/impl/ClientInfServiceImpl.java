package com.springmvc.service.impl;

import com.springmvc.entity.ClientInf;
import com.springmvc.entity.ClientOrder;
import com.springmvc.mapper.ClientInfMapper;
import com.springmvc.service.ClientInfService;
import com.springmvc.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientInfServiceImpl implements ClientInfService {

    @Resource
    private ClientInfMapper clientInfMapper;


    @Override
    public List<ClientInf> queryAllByLimit(int offset, int limit) {
        return this.clientInfMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public List<ClientInf> getClientInfAll() {
        return  this.clientInfMapper.queryClientAll();
    }

    @Override
    public List<ClientInf> queryClientInfByInf(ClientInf clientInf) {
        return  this.clientInfMapper.queryClientByInf(clientInf);
    }

    @Override
    public ClientInf insert(ClientInf clientInf) {
        this.clientInfMapper.insert(clientInf);
        return clientInf;
    }

    @Override
    public boolean update(ClientInf clientInf) {
        return  this.clientInfMapper.update(clientInf)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.clientInfMapper.deleteById(id)>0;
    }

    @Override
    public int CountAll() {
        return this.clientInfMapper.CountAll();
    }
}
