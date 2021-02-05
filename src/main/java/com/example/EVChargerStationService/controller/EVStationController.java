package com.example.EVChargerStationService.controller;

import com.example.EVChargerStationService.entity.EVStation;
import com.example.EVChargerStationService.entity.RepairShop;
import com.example.EVChargerStationService.entity.RequestEVStation;
import com.example.EVChargerStationService.repository.EVStationRepository;
import com.example.EVChargerStationService.repository.RepairShopRepository;
import com.example.EVChargerStationService.repository.RequestEVStationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
@Slf4j
public class EVStationController {

    @Autowired
    private EVStationRepository evStationRepository;
    @Autowired
    private RequestEVStationRepository requestEvStationRepository;
    @Autowired
    private RepairShopRepository repairShopRepository;

    //전기차 충전소 위치정보 페이지
    @GetMapping("/EVStationMap")
    public String EVChargingStationMap(Model model) {

        evStationRepository.deleteAll();
        EVStationAPIread();
        //충전소 DB에서 가져오기
        List<EVStation> EVStationList = new ArrayList<>();
        // evStationRepository.findAll().forEach(e -> EVStationList.add(e));
        EVStationList = (List<EVStation>)evStationRepository.findAll();

        log.info("충전소 개수 : " + String.valueOf(EVStationList.size()));
        model.addAttribute("stations", EVStationList);

        //정비소 DB에서 가져오기
        List<RepairShop> RepairShopList = new ArrayList<>();
        // evStationRepository.findAll().forEach(e -> EVStationList.add(e));
        RepairShopList = (List<RepairShop>)repairShopRepository.findAll();

        log.info("정비소 개수 : " + String.valueOf(RepairShopList.size()));
        model.addAttribute("repairshops", RepairShopList);

        return "/EVstationMap";
    }

    //충전소가 필요한 위치에 마커를 표시하는 페이지
    @GetMapping("/RequestEVStationMap")
    public String RequestEVStationMap(Model model) {
        List<RequestEVStation> markerlist = new ArrayList<>();
        requestEvStationRepository.findAll().forEach(e -> markerlist.add(e));
        log.info("마커 개수 : " + String.valueOf(markerlist.size()));
        model.addAttribute("markers", markerlist);

        return "/RequestEVStationMap";
    }

    @GetMapping("/RequestEVStationMap/update")
    public String RequestEVStationMapUpdate(HttpServletRequest httpServletRequest, Model model) {
        int recomID = Integer.parseInt(httpServletRequest.getParameter("id"));
        int recomCount = Integer.parseInt(httpServletRequest.getParameter("count"));
        Optional<RequestEVStation> req = requestEvStationRepository.findById((long) recomID);
        req.ifPresent(selectID ->{
            selectID.setRecommendationCount(recomCount+1);
            RequestEVStation newRequestEVStation = requestEvStationRepository.save(selectID);
            log.info("count 개수 : " + newRequestEVStation);
        });

        return "/RequestEVStationMap";
    }

    //마커를 새로 생성
    @GetMapping("/EVStationMarkerCreate")
    public String CreateEVStationMarker(@RequestParam("Comment") String comment, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("RecommendationCount") int RecommendationCount) {
        //System.out.println(form.toString());

        RequestEVStation requestEVStation = new RequestEVStation(null, latitude, longitude, comment, RecommendationCount);

        RequestEVStation saved = requestEvStationRepository.save(requestEVStation);
        System.out.println(saved.toString());

        return "redirect:/RequestEVStationMap";
    }


    @GetMapping("/apitest")
    public String callapihttp() {
        StringBuffer result = new StringBuffer();
        try {
            String urlstr = "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?"+
                    "ServiceKey=MKalVDv7C9R0%2F26oZlr6qIdmvzJToDcLqylzcPVgVnCfW5U%2B9LnvjvI8ojleXwJRnW5g52yxRq9FWLBy3YPRzQ%3D%3D"+
                    "&pageNo=1"+
                    "&numOfRows=10";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
            urlconnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
            String returnLine;
            result.append("<xmp>");
            while((returnLine = br.readLine())!=null) {
                result.append(returnLine + "\n");
            }
            //urlconnection.disconnect();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result+"</xmp>";

    }

    public String EVStationAPIread(){

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

                        setstationvalue(getTagValue("statNm", element), getTagValue("lat", element), getTagValue("lng", element),
                                getTagValue("addr", element), getTagValue("chgerType", element),getTagValue("useTime", element),
                                getTagValue("stat", element), getTagValue("statUpdDt", element), getTagValue("busiCall", element),
                                getTagValue("parkingFree", element));

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
        return "redirect:/EVStationMap";
    }//main

    public void setstationvalue(String name, String lat, String lng, String addr, String chgerType, String useTime, String stat, String statUpdDt, String busiCall, String parkingFree){

        EVStation evstation = new EVStation(null,name,addr, lat,lng,chgerType,useTime,stat,statUpdDt,busiCall,parkingFree);

        /*evstation.setlatitude(lat);
        evstation.setlongitude(lng);
        evstation.setRoadAddress(addr);
        evstation.setchargertype(chgerType);*/

        evStationRepository.save(evstation);
    }

    private static String getTagValue(String tag, Element ele) {

        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();

        Node nValue = (Node) nodeList.item(0);

        if(nValue == null) {

            return null;

        }

        return nValue.getNodeValue();

    }
}
