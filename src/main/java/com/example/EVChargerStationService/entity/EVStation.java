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

    @Column(name = "NAME")
    private String name;                //충전소명

    @Column(name = "ROADADDRESS")
    private String roadAddress;         //도로명주소

    @Column(name = "LATITUDE")
    private String latitude;            //위도

    @Column(name = "LONGITUDE")
    private String longitude;           //경도

    @Column(name = "CHARGERTYPE")
    private int chargerType;            //충전기타입(01:DC차데모,02: AC완속,03: DC차데모+AC3상,04: DC콤보,05: DC차데모+DC콤보, 06: DC차데모+AC3상+DC콤보,07: AC3상)

    @Column(name = "USETIME")
    private String useTime;              //이용가능시간

    @Column(name = "STAT")
    private int stat;                    //충전기상태(1: 통신이상, 2: 충전대기,3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)

    @Column(name = "STATUPDDT")
    private String statUpdDt;            //상태갱신일시   예):20190829121020

    @Column(name = "BUSICALL")
    private String busiCall;             //충전기 운영기관 연락처


    //기존에 있던 entity
    /*@Id
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
    private String supportedVehicles;   //지원차종*/
}
