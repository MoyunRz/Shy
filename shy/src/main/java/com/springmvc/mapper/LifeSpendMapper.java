package com.springmvc.mapper;

import com.springmvc.entity.LifeSpend;
import com.springmvc.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LifeSpendMapper {

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    List<LifeSpend> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<LifeSpend> queryLifeSpendAll();

    List<LifeSpend> queryLifeSpendByInf(LifeSpend lifeSpend);

    int addSpend(LifeSpend lifeSpend);

    int update(LifeSpend lifeSpend);

    int deleteById(String id);
}
