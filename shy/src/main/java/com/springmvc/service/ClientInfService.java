package com.springmvc.service;

import com.springmvc.entity.ClientInf;
import java.util.List;

public interface ClientInfService {

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClientInf> queryAllByLimit(int offset, int limit);

    /**
     * 根据用户名获取该用户预订的订单
     * @param
     * @return
     */

    List<ClientInf> getClientInfAll();

    List<ClientInf> queryClientInfByInf(ClientInf clientInf);
    /**
     * 新增数据
     * @param clientInf 实例对象
     * @return 实例对象
     */
    ClientInf insert(ClientInf clientInf);

    /**
     * 修改数据
     *
     * @param clientInf 实例对象
     * @return 实例对象
     */
    boolean update(ClientInf clientInf);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
