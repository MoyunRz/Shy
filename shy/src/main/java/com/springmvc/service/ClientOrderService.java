package com.springmvc.service;

import com.springmvc.entity.ClientOrder;

import java.util.List;

public interface ClientOrderService {

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     List<ClientOrder> queryAllByLimit(int offset, int limit);

     /**
     * 根据用户名获取该用户预订的订单
     * @param
     * @return
     */

    List<ClientOrder> getClientOrderAll();

    List<ClientOrder> queryClientOrderByInf(ClientOrder clientOrder);
    /**
     * 新增数据
     * @param clientOrder 实例对象
     * @return 实例对象
     */
    ClientOrder insert(ClientOrder clientOrder);

    /**
     * 修改数据
     *
     * @param clientOrder 实例对象
     * @return 实例对象
     */
    boolean update(ClientOrder clientOrder);

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 是否成功
     */
    boolean OrderdeleteById(String oid);
}
