package com.springmvc.service.impl;

import com.springmvc.entity.Material;
import com.springmvc.mapper.MaterialMapper;
import com.springmvc.service.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Resource
    MaterialMapper materialMapper;

    @Override
    public List<Material> queryAllByLimit(int offset, int limit) {
        return this.materialMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Material> getMaterialAll() {
        return this.materialMapper.queryMaterialAll();
    }

    @Override
    public List<Material> queryMaterialByInf(Material material) {
        return this.materialMapper.queryMaterialByInf(material);
    }

    @Override
    public boolean addMaterial(Material material) {
        int i=0;
        i=this.materialMapper.addMaterial(material);
        return  i>0;
    }

    @Override
    public boolean update(Material material) {
        return this.materialMapper.update(material)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.materialMapper.deleteById(id)>0;
    }
}
