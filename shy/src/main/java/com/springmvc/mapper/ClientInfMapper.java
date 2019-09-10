package com.springmvc.mapper;

import com.springmvc.entity.ClientInf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientInfMapper {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClientInf> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询全部用户订单信息
     * @return
     */
    List<ClientInf> queryClientAll();

    /**
     * 新增数据
     *
     * @param client 实例对象
     * @return 影响行数
     */
    int insert(ClientInf client);

    /**
     * 修改数据
     *
     * @param client 实例对象
     * @return 影响行数
     */
    int update(ClientInf client);

    /**
     *  通过主键删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     *  指定定信息查询
     * @param client
     * @return
     */
    List<ClientInf> queryClientByInf(ClientInf client);
}
