package com.example.EVChargerStationService.entity;

import lombok.*;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.SynchronizationCallbackCoordinatorNonTrackingImpl;
import sun.jvm.hotspot.gc.shared.Generation;

import javax.persistence.*;


@Entity
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "EVstations")
public class EVStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column(name = "LOCATION")
    //private String location;            //설치장소

    @Column(name = "ROADADDRESS")
     private String roadAddress;         //도로명주소

    @Column(name = "LATITUDE")
    private String latitude;            //위도

    @Column(name = "LONGITUDE")
    private String longitude;           //경도

    //@Column(name = "STANDARDCHARGERNUM")
    //private int standardChargerNum;     //급속충전기 대수

   // @Column(name = "NORMALCHARGERNUM")
   // private int normalChargerNum;       //완속충전기 대수

    //@Column(name = "SUPPORTEDVEHICLES")
    //private String supportedVehicles;   //지원차종
    @Column(name="CHARGERTYPE")
    private String chargertype;

    public EVStation(String roadAddress, String latitude, String longitude, String chargertype) {
        this.roadAddress = roadAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.chargertype = chargertype;
    }
public long getId(){
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
}
@Override
public String toString(){
        return "EVStation [id=" + id + ", RoadAddress =" +roadAddress + ", latitude =" + latitude + ", longitude =" + longitude +
                ", chargertype=" + chargertype + "]";
}
}
