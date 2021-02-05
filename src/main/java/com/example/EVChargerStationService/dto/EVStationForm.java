package com.example.EVChargerStationService.dto;

import com.example.EVChargerStationService.entity.RequestEVStation;
import com.example.EVChargerStationService.entity.EVStation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EVStationForm {
    //public EVStation toEntity()
    //{
       // return new EVStation(null,roadAddress,latitude,longitude,chargertype);
   // }
    private int id; //id
    //private String location;            //설치위치
    private String roadAddress;         //도로명주소
    private String latitude;            //위도
    private String longitude;           //경도
    //private int standardChargerNum;     //급속충전기 대수
    //private int normalChargerNum;       //완속충전기 대수
    //private String supportedVehicles;   //지원차종
    private String chargertype;
}
