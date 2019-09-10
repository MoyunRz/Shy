package com.springmvc.service;

import com.springmvc.entity.Material;

import java.util.List;


public interface MaterialService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Material> queryAllByLimit(int offset, int limit);

    /**
     *  获取全部材料订单
     * @return
     */
    List<Material> getMaterialAll();

    /**
     * 根据条件查询订单
     * @param material
     * @return
     */
    List<Material> queryMaterialByInf(Material material);

    /**
     * 新增数据
     * @param material 实例对象
     * @return 实例对象
     */
    boolean addMaterial(Material material);

    /**
     * 修改数据
     * @param material 实例对象
     * @return 实例对象
     */
    boolean update(Material material);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
