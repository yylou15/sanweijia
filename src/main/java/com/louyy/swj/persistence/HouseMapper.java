package com.louyy.swj.persistence;

import com.louyy.swj.domain.House;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface HouseMapper {
    public List<House> getHouseInfo();
    List<House> getHouseInfoListGroupByRegion();
    List<House> getHouseInfoListGroupByYear();
}
