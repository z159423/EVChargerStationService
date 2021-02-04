package com.example.EVChargerStationService.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EVStation {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "LOCATION")
    private String location;            //설치장소

    @Column(name = "ROADADDRESS")
    private String roadAddress;         //도로명주소

    @Column(name = "LATITUDE")
    private String latitude;            //위도

    @Column(name = "LONGITUDE")
    private String longitude;           //경도

    @Column(name = "STANDARDCHARGERNUM")
    private int standardChargerNum;     //급속충전기 대수

    @Column(name = "NORMALCHARGERNUM")
    private int normalChargerNum;       //완속충전기 대수

    @Column(name = "SUPPORTEDVEHICLES")
    private String supportedVehicles;   //지원차종
}
