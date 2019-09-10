package com.springmvc.mapper;


import com.springmvc.entity.ClientOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface ClientOrderMapper {

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
     List<ClientOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询全部用户订单信息
     * @return
     */
     List<ClientOrder> queryClientOrderAll();

    /**
     * 新增数据
     *
     * @param clientOrder 实例对象
     * @return 影响行数
     */
    int insert(ClientOrder clientOrder);

    /**
     * 修改数据
     *
     * @param clientOrder 实例对象
     * @return 影响行数
     */
    int update(ClientOrder clientOrder);

    /**
     *  通过主键删除
     * @param oid
     * @return
     */
     int OrderdeleteById(String oid);

    /**
     *  指定定信息查询
     * @param clientOrder
     * @return
     */
    List<ClientOrder> queryClientOrderByInf(ClientOrder clientOrder);
}
