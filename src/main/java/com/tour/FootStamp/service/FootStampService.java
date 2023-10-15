package com.tour.FootStamp.service;

import com.tour.FootStamp.dto.FootStampDto;
import com.tour.FootStamp.entity.FootStamp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FootStampService {

    public FootStamp addStamp(FootStampDto footStampDto) throws Exception;
}
