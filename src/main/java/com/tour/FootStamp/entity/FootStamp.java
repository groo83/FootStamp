package com.tour.FootStamp.entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class FootStamp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String stamp_no;

    private String contents;

    private String content_id;

    private String member_id;

    private String max_X;

    private String max_Y;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

}
