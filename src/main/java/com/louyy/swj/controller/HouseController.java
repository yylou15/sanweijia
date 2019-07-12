package com.louyy.swj.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.louyy.swj.domain.House;
import com.louyy.swj.service.HouseService;
import com.louyy.swj.service.impl.HouseServiceImpl;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @CrossOrigin
    @RequestMapping("/info")
    public List<House> getHouseInfo(){
        return houseService.getHouseInfoList();
    }

    @CrossOrigin
    @RequestMapping("/groupByRegion")
    public List<House> getHougroupByRegionInfo(){
        return houseService.getHouseInfoListGroupByRegion();
    }

    @CrossOrigin
    @RequestMapping("/groupByYear")
    public List<House> getHougroupByYear(){
        return houseService.getHouseInfoListGroupByRegion();
    }



}
