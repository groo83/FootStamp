package com.tour.FootStamp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class FootStampDto {
    private String contents;
    private byte[] image;
    //private MultipartFile image;
}
