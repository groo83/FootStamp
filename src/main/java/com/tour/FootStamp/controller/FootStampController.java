package com.tour.FootStamp.controller;

import com.tour.FootStamp.dto.CommonDto;
import com.tour.FootStamp.dto.FootStampDto;
import com.tour.FootStamp.service.FootStampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/footstamp", method = { RequestMethod.GET, RequestMethod.POST })
public class FootStampController {

    @Autowired
    FootStampService footStampService;

    @RequestMapping("register")
    public String searchTouristSpot(Model model, MultipartHttpServletRequest multipartHttpServletRequest, FootStampDto footStampDto){
        List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("files[]");

        try {
            if(multipartFiles.size() == 1) {
                footStampDto.setImage(multipartFiles.get(0).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //List<footStampDto> list = footStampService.register( footStampDto );

        //model.addAttribute("touristSpotList", list);
        return "touristSpot";
    }
}
