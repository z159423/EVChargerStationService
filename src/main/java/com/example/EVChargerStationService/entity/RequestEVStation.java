package com.example.EVChargerStationService.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name="EVStation_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="RequestEVStation_seq", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class RequestEVStation {

    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="EVStation_SEQ_GEN" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정
    )
    Long id;

    @Column(name = "LATITUDE")
    String latitude;            //위도
    @Column(name = "LONGITUDE")
    String longitude;           //경도
    @Column(name = "MARKERCOMMENT")
    String markerComment;             //의견
    @Column(name = "RECOMMENDATIONCOUNT")
    int recommendationCount;    //추천

    /*public RequestEVStation(Long id, String latitude, String longitude, String markerComment, int recommendationCount) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.markerComment = markerComment;
        this.recommendationCount = recommendationCount;
    }*/
}
