package com.tour.FootStamp.controller;

import com.tour.FootStamp.common.code.ContentTypeIdCode;
import com.tour.FootStamp.common.code.EtcCode;
import com.tour.FootStamp.common.code.OperationCode;
import com.tour.FootStamp.dto.CommonDto;
import com.tour.FootStamp.dto.DetailDto;
import com.tour.FootStamp.service.SearchService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
public class SearchController {

    @Autowired
    SearchService searchService;

    // TODO 공통화 (ContentTypeIdCode.TOURIST_SPOT -> contentTypeId 대체)
    @RequestMapping("touristSpot")
    public String searchTouristSpot(Model model){
        List<CommonDto> list = searchService.searchTourApi( OperationCode.SEARCH_TYPE_AREA, ContentTypeIdCode.TOURIST_SPOT );

        model.addAttribute("touristSpotList", list);
        return "touristSpot";
    }

    @RequestMapping("detailContent")
    public String searchDetail(Model model, CommonDto commonDto, HttpSession session){
        DetailDto detail = searchService.searchDetailTourApi( commonDto );

        model.addAttribute("detail", detail);

        model.addAttribute("loginEmail", session.getAttribute("loginEmail"));
        return "detailContent";
    }

    @RequestMapping("registerableStamp")
    public String searchRegisterableStamp(Model model, CommonDto commonDto){
        List<DetailDto> registerableStamp = searchService.searchRegisterableStamp( commonDto, EtcCode.DEFAULT_MAX_REDIUS );

        model.addAttribute("registerableStamp", registerableStamp);
        return "registerableStamp";//redirect:../templates/
    }
}
