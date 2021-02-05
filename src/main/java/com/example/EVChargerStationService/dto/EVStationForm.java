package com.example.EVChargerStationService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EVStationForm {

    private String name;                //충전소이름
    private String roadAddress;         //주소
    private String latitude;            //위도
    private String longitude;           //경도
    private String chargertype;         //충전기타입(01:DC차데모,02: AC완속,03: DC차데모+AC3상,04: DC콤보,05: DC차데모+DC콤보, 06: DC차데모+AC3상+DC콤보,07: AC3상)

    private String useTime;              //이용가능시간
    private String stat;                    //충전기상태(1: 통신이상, 2: 충전대기,3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)
    private String statUpdDt;            //상태갱신일시   예):20190829121020
    private String busiCall;             //충전기 운영기관 연락처
    private String parkingFree;          //주차장 무료 = Y / 유료 = N
    private String powerType;            //충전량


    //기존에 있던 폼
    /*private String location;            //설치위치
    private String roadAddress;         //주소
    private String latitude;            //위도
    private String longitude;           //경도
    private String chargerType;         //충전기타입(01:DC차데모,02: AC완속,03: DC차데모+AC3상,04: DC콤보,05: DC차데모+DC콤보, 06: DC차데모+AC3상+DC콤보,07: AC3상)

    private String useTime;              //이용가능시간
    private int stat;                    //충전기상태(1: 통신이상, 2: 충전대기,3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)
    private String statUpdDt;            //상태갱신일시   예):20190829121020
    private String busiCall;             //충전기 운영기관 연락처*/
}
