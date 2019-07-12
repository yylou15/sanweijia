package com.louyy.swj.service.impl;

import com.louyy.swj.domain.House;
import com.louyy.swj.persistence.HouseMapper;
import com.louyy.swj.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> getHouseInfoList() {
        return houseMapper.getHouseInfo();
    }

    @Override
    public List<House> getHouseInfoListGroupByRegion() {
        return houseMapper.getHouseInfoListGroupByRegion();
    }

    @Override
    public List<House> getHouseInfoListGroupByYear() {
        return houseMapper.getHouseInfoListGroupByYear();
    }
}
