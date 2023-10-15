package com.tour.FootStamp.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class FootStampDto {
    private String contentId;

    private String memberEmail;

    private String mapX;

    private String mapY;

    private String contents;

    //private byte[] files;
    private MultipartFile files;
}
