package com.example.EVChargerStationService.controller;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;


import com.example.EVChargerStationService.entity.EVStation;
import com.example.EVChargerStationService.repository.EVStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;


import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;
import org.junit.runner.RunWith;
@RestController
public class RemoteController {
    //item 정보를 가져오는 메소드

    private static String getTagValue(String tag, Element ele) {

        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();

        Node nValue = (Node) nodeList.item(0);

        if(nValue == null) {

            return null;

        }

        return nValue.getNodeValue();

    }



    @Autowired
    private EVStationRepository evStationRepository;


    public void setstationvalue(String lat, String lng, String addr, String chgerType){

        EVStation evstation = new EVStation();
        evstation.setlatitude(lat);
        evstation.setlongitude(lng);
        evstation.setRoadAddress(addr);
        evstation.setchargertype(chgerType);
        evStationRepository.save(evstation);
    }
    @GetMapping("/EVStationtest")
    public String EVChargingStationMap(Model model){

        int page=1;
        try {

            while(true) {

                //parsing할 url 지정

                String url = "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?serviceKey=eTj%2BoTexoAoUQ5MNZDEb4qxLyrEY9pD5PcD1ogXd4cc1QuwQWlqBq1E7ehDcBcSd3%2BcAV5jbKJaIhLEzK2OoWw%3D%3D&pageNo=1&numOfRows=3400";

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();

                Document doc = dBuilder.parse(url);



                //root tag

                doc.getDocumentElement().normalize();

                System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());



                // parsing tag

                NodeList nodeList = doc.getElementsByTagName("item");

                System.out.println("파싱할 리스트 수 : "+ nodeList.getLength());

                for(int temp =0; temp<nodeList.getLength(); temp++) {

                    Node nNode = nodeList.item(temp);

                    if(nNode.getNodeType()==Node.ELEMENT_NODE) {

                        Element element = (Element) nNode;

                        setstationvalue(getTagValue("lat", element), getTagValue("lng", element),
                                        getTagValue("addr", element), getTagValue("chgerType", element));

                    }//if

                }//for

                page += 1;

                if(page >= 2) {

                    break;

                }

            }//while

        } catch (Exception e) {

            e.printStackTrace();

        }
    return "/EVStationMAP";
    }//main
}
