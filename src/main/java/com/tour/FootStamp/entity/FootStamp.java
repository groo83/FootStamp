package com.tour.FootStamp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tb_footstamp")
public class FootStamp extends BaseTimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampNo;

    private String contents;

    private String contentId;

    private String memberEmail;

    @Column(name = "map_x")
    private String mapX;

    @Column(name = "map_y")
    private String mapY;

    /*
    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;
    */

    private String originalFileName;

    private String storedFileName;

    private long fileSize;
}
