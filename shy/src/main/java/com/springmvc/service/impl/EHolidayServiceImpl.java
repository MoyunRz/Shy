package com.springmvc.service.impl;

import com.springmvc.entity.EHoliday;
import com.springmvc.mapper.EHolidayMapper;
import com.springmvc.service.EHolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EHolidayServiceImpl implements EHolidayService {

    @Resource
    EHolidayMapper eHolidayMapper;

    @Override
    public List<EHoliday> queryAllByLimit(int offset, int limit) {
        return this.eHolidayMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public List<EHoliday> getEHolidayAll() {
        return this.eHolidayMapper.queryEHolidayAll();
    }

    @Override
    public List<EHoliday> queryEHolidayByInf(EHoliday eHoliday) {
        return this.eHolidayMapper.queryEHolidayByInf(eHoliday);
    }

    @Override
    public boolean addEHoliday(EHoliday eHoliday) {
        return this.eHolidayMapper.insert(eHoliday)>0;
    }

    @Override
    public boolean update(EHoliday eHoliday) {
        return this.eHolidayMapper.update(eHoliday)>0;
    }

    @Override
    public boolean deleteById(String id) {
        return this.eHolidayMapper.deleteById(id)>0;
    }
}
