package com.tour.FootStamp.controller;

import com.tour.FootStamp.common.code.EtcCode;
import com.tour.FootStamp.dto.CommonDto;
import com.tour.FootStamp.dto.DetailDto;
import com.tour.FootStamp.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
public class HomeController {

    @Autowired
    SearchService searchService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model, CommonDto commonDto){
        System.out.println(commonDto.getMapy());
        System.out.println(commonDto.getMapx());

        List<DetailDto> registerableStamp = searchService.searchRegisterableStamp( commonDto, EtcCode.DEFAULT_MAX_REDIUS );

        model.addAttribute("registerableStamp", registerableStamp);

        return "home";
    }
}
