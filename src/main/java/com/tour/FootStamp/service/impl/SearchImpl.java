package com.tour.FootStamp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.FootStamp.common.code.EtcCode;
import com.tour.FootStamp.common.code.OperationCode;
import com.tour.FootStamp.common.connection.UrlConnection;
import com.tour.FootStamp.config.Etc;
import com.tour.FootStamp.dto.CommonDto;
import com.tour.FootStamp.dto.DetailDto;
import com.tour.FootStamp.service.SearchService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchImpl implements SearchService {

    @Autowired Etc etc;

    @Override
    public List<CommonDto> searchTourApi(final String operationName, final String contentTypeId) {
        String tourApiUrl = "http://apis.data.go.kr/B551011/KorService1/" + operationName;

        String param = "serviceKey=" + etc.getApiKey() + "&pageNo=1&numOfRows=10&MobileApp=AppTest&MobileOS=ETC&arrange=A&_type=json&"
                        + "contentTypeId=" + contentTypeId;

        String returnData = UrlConnection.getRequest(tourApiUrl, param);

        JSONArray items =  parseJsonStrToJsonArr(returnData);
        List<CommonDto> searchList = castedGenericList(items);

        if (searchList == null || searchList.isEmpty())
            searchList = new ArrayList<>();

        return searchList;
    }

    @Override
    public DetailDto searchDetailTourApi(final CommonDto commonDto) {
        String tourApiUrl = "http://apis.data.go.kr/B551011/KorService1/" + OperationCode.SEARCH_TYPE_DETAIL;

        // defaultYN : 상세 정보 조회 flag
        String param = "serviceKey=" + etc.getApiKey() + "&pageNo=1&numOfRows=10&MobileApp=AppTest&MobileOS=ETC&_type=json&defaultYN=Y&firstImageYN=Y&mapinfoYN=Y&overviewYN=Y&areacodeYN=Y&"
                        + "contentId=" + commonDto.getContentId();

        String returnData = UrlConnection.getRequest(tourApiUrl, param);

        JSONArray items =  parseJsonStrToJsonArr(returnData);
        DetailDto detail = castedDetailDto(items);

        if (detail == null)
            return detail = new DetailDto();
        else
            return detail;
    }

    @Override
    public List<DetailDto> searchRegisterableStamp(final CommonDto commonDto, final int maxRedius) {
        String tourApiUrl = "http://apis.data.go.kr/B551011/KorService1/" + OperationCode.SEARCH_TYPE_LOCATION;

        String param = "serviceKey=" + etc.getApiKey() + "&pageNo=1&numOfRows=10&MobileApp=AppTest&MobileOS=ETC&_type=json&arrange=A&listYN=Y&"
                + "mapX=" + commonDto.getMapx() + "&mapY=" + commonDto.getMapy() + "&radius=" + maxRedius;

        String returnData = UrlConnection.getRequest(tourApiUrl, param);

        JSONArray items =  parseJsonStrToJsonArr(returnData);
        List<DetailDto> searchList = castedGenericList(items);


        if (searchList == null || searchList.isEmpty())
            searchList = new ArrayList<>();

        return searchList;
    }

    public JSONArray parseJsonStrToJsonArr(final String jsonStr){
        JSONArray resultItem = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject resultObj = (JSONObject)parser.parse(jsonStr);

            // nested JSON 처리
            JSONObject resultResp = (JSONObject) resultObj.get(EtcCode.KEY_RESPONSE);
            JSONObject resultBody = (JSONObject) resultResp.get(EtcCode.KEY_BODY);
            JSONObject resultItems = (JSONObject) resultBody.get(EtcCode.KEY_ITEMS);
            resultItem = (JSONArray) resultItems.get(EtcCode.KEY_ITEM);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(resultItem == null || resultItem.isEmpty())
            resultItem = new JSONArray();

        return resultItem;
    }

    public <T> List<T> castedGenericList( final JSONArray array ){
        List<T> list = array.stream().toList();

        return (list == null) ? list = new ArrayList<T>() : list;
    }

    public DetailDto castedDetailDto (final JSONArray array){
        //List<DetailDto> list = array.stream().toList(); // detailDto classcastexception 발생으로 인한 별도 parsing
        JSONObject item = (JSONObject) array.get(0);

        ObjectMapper mapper = new ObjectMapper();
        DetailDto detail = new DetailDto();
        System.out.println("json string ="+item.toJSONString());
        try {
            // detail = mapper.readValue(item.toJSONString(), DetailDto.class);
            // contentid missing(null) -> 수동 변환
            detail.setContentId(String.valueOf(item.get("contentid")));
            detail.setBooktour(String.valueOf(item.get("booktour")));
            detail.setHomepage(String.valueOf(item.get("homepage")));
            detail.setAreacode(String.valueOf(item.get("areacode")));
            detail.setMlevel(String.valueOf(item.get("mlevel")));
            detail.setDist(String.valueOf(item.get("dist")));
            detail.setContentTypeId(String.valueOf(item.get("contenttypeid")));
            detail.setAddr1(String.valueOf(item.get("addr1")));
            detail.setMapx(String.valueOf(item.get("mapx")));
            detail.setMapy(String.valueOf(item.get("mapy")));
            detail.setTitle(String.valueOf(item.get("title")));
            detail.setTel(String.valueOf(item.get("tel")));
            detail.setFirstimage(String.valueOf(item.get("firstimage")));
            detail.setFirstimage2(String.valueOf(item.get("firstimage2")));
            detail.setOverview(String.valueOf(item.get("overview")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detail;
    }
}
