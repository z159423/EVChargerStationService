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
public class RepairShop {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "NAME")
    private String name;                //정비소 이름

    @Column(name = "ROADADDRESS")
    private String roadAddress;         //도로명주소

    @Column(name = "LATITUDE")
    private String latitude;            //위도

    @Column(name = "LONGITUDE")
    private String longitude;           //경도

    @Column(name = "PHONENUMBER")
    private String phoneNumber;         //전화번호
}
