package com.springmvc.service.impl;

import com.springmvc.entity.ClientOrder;
import com.springmvc.mapper.ClientOrderMapper;
import com.springmvc.service.ClientOrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {
    @Resource
    private ClientOrderMapper clientOrderMapper;
    @Override
    public List<ClientOrder> queryAllByLimit(int offset, int limit) {
        return this.clientOrderMapper.queryAllByLimit(offset,limit);
    }
    @Override
    public List<ClientOrder> getClientOrderAll(){

        return this.clientOrderMapper.queryClientOrderAll();
    }

    @Override
    public List<ClientOrder> queryClientOrderByInf(ClientOrder clientOrder) {
        return this.clientOrderMapper.queryClientOrderByInf(clientOrder);
    }

    /**
     * 添加客户订单
     * @param clientOrder 实例对象
     * @return
     */
    @Override
    public ClientOrder insert(ClientOrder clientOrder) {
        this.clientOrderMapper.insert(clientOrder);
        return clientOrder;
    }

    /**
     *  更新客户订单
     * @param clientOrder 实例对象
     * @return
     */
    @Override
    public boolean update(ClientOrder clientOrder) {
        return this.clientOrderMapper.update(clientOrder)>0;
    }

    /**
     * 根据ID删除
     * @param oid 主键
     * @return
     */
    @Override
    public boolean OrderdeleteById(String oid){
        return this.clientOrderMapper.OrderdeleteById(oid)>0;
    }

}
