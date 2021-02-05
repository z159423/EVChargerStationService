package com.example.EVChargerStationService.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor
public class EVStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String chargertype;            //충전기타입(01:DC차데모,02: AC완속,03: DC차데모+AC3상,04: DC콤보,05: DC차데모+DC콤보, 06: DC차데모+AC3상+DC콤보,07: AC3상)

    @Column(name = "USETIME")
    private String useTime;              //이용가능시간

    @Column(name = "STAT")
    private String stat;                    //충전기상태(1: 통신이상, 2: 충전대기,3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)

    @Column(name = "STATUPDDT")
    private String statUpdDt;            //상태갱신일시   예):20190829121020

    @Column(name = "BUSICALL")
    private String busiCall;             //충전기 운영기관 연락처

    @Column(name = "PARKINGFREE")
    private String parkingFree;          //주차장 무료 = Y / 유료 = N

    public EVStation(Long id, String name, String roadAddress, String latitude, String longitude, String chargertype, String useTime, String stat, String statUpdDt, String busiCall, String parkingFree) {
        this.id = id;
        this.name = name;
        this.roadAddress = roadAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.chargertype = chargertype;
        this.useTime = useTime;
        this.stat = stat;
        this.statUpdDt = statUpdDt;
        this.busiCall = busiCall;
        this.parkingFree = parkingFree;
    }

/*public long getId(){
        return id;
    }

    public String getRoadAddress(){
        return roadAddress;
    }
    public void setRoadAddress(String roadAddress){
        this.roadAddress = roadAddress;
    }
    public String getlatitude(){
        return latitude;
    }
    public void setlatitude(String latitude){
        this.latitude = latitude;
    }
    public String getlongitude(){
        return longitude;
    }
    public void setlongitude(String longitude){
        this.longitude = longitude;
    }
    public String getchargertype(){
        return chargertype;
    }
    public void setchargertype(String chargertype){
        this.chargertype = chargertype;
    }*/

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
