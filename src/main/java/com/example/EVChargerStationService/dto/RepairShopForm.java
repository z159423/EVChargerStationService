package com.example.EVChargerStationService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RepairShopForm {

    private String name;            //정비업체 이름
    private String roadAddress;         //도로명주소
    private String latitude;            //위도
    private String longitude;           //경도
    private String phoneNumber;   //전화번호
}
