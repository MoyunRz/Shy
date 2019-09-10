package com.springmvc.service.impl;

import com.springmvc.entity.LifeSpend;
import com.springmvc.mapper.LifeSpendMapper;
import com.springmvc.service.LifeSpendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LifeSpendServiceImpl implements LifeSpendService {
    @Resource
    LifeSpendMapper lifeSpendMapper;

    @Override
    public List<LifeSpend> queryAllByLimit(int offset, int limit) {
        return this.lifeSpendMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public List<LifeSpend> getLifeSpendAll() {
        return this.lifeSpendMapper.queryLifeSpendAll();
    }

    @Override
    public List<LifeSpend> queryLifeSpendByInf(LifeSpend lifeSpend) {
        return this.lifeSpendMapper.queryLifeSpendByInf(lifeSpend);
    }

    @Override
    public boolean addSpend(LifeSpend lifeSpend) {

        return  this.lifeSpendMapper.addSpend(lifeSpend)>0;
    }

    @Override
    public boolean update(LifeSpend lifeSpend) {
        return this.lifeSpendMapper.update(lifeSpend)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.lifeSpendMapper.deleteById(id)>0;
    }
}
