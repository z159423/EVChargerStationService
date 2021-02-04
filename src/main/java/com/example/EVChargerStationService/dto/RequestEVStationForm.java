package com.example.EVChargerStationService.dto;

import com.example.EVChargerStationService.entity.RequestEVStation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestEVStationForm {

    private String latitude;            //위도
    private String longitude;           //경도
    private String markerComment;             //의견
    private int recommendationCount;    //추천

    public RequestEVStation toEntity()
    {
        return new RequestEVStation(null,latitude,longitude,markerComment,recommendationCount);
    }
}
