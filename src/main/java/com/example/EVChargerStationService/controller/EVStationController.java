package com.example.EVChargerStationService.controller;

import com.example.EVChargerStationService.entity.EVStation;
import com.example.EVChargerStationService.entity.RequestEVStation;
import com.example.EVChargerStationService.repository.EVStationRepository;
import com.example.EVChargerStationService.repository.RequestEVStationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class EVStationController {

    @Autowired
    private EVStationRepository evStationRepository;
    @Autowired
    private RequestEVStationRepository requestEvStationRepository;

    //전기차 충전소 위치정보 페이지
    @GetMapping("/EVStationMap")
    public String EVChargingStationMap(Model model) {

        List<EVStation> EVStationList = new ArrayList<>();
        // evStationRepository.findAll().forEach(e -> EVStationList.add(e));
        EVStationList = (List<EVStation>)evStationRepository.findAll();

        log.info("충전소 개수 : " + String.valueOf(EVStationList.size()));
        model.addAttribute("stations", EVStationList);

        return "/EVstationMap";
    }

    //충전소가 필요한 위치에 마커를 표시하는 페이지
    @GetMapping("/RequestEVStationMap")
    public String RequestEVStationMap() {


        return "/RequestEVStationMap";
    }
}
