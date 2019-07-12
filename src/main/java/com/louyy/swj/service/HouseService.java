package com.louyy.swj.service;

import com.louyy.swj.domain.House;

import java.util.List;

public interface HouseService {
    public List<House> getHouseInfoList();

    List<House> getHouseInfoListGroupByRegion();
    List<House> getHouseInfoListGroupByYear();
}
