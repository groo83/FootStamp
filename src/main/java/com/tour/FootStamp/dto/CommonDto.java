package com.tour.FootStamp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter //client->server(form data)
@NoArgsConstructor
@JsonNaming
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonDto {

    /*
     * 지역코드
     */
    private String areacode;

    /*
     * 시군구코드
     */
    private String sigungucode;

    /*
     * 대분류
     */
    private String cat1;

    /*
     * 중분류
     */
    private String cat2;

    /*
     * 소분류
     */
    private String cat3;

    /*
     * 콘텐츠ID
     */
    private String contentId;

    /*
     * 콘텐츠ID (등록가능한 발도장 응답)
     */
    private String contentid;

    /*
     * 관광타입 ID
     */
    private String contentTypeId;

    /*
     * 관광타입 ID (등록가능한 발도장 응답)
     */
    private String contenttypeid;

    /*
     * 주소
     */
    private String addr1;

    /*
     * 상세주소
     */
    private String addr2;

    /*
     * 우편번호
     */
    private String zipcode;

    /*
     * GPS X좌표
     */
    private String mapx;

    /*
     * GPS Y좌표
     */
    private String mapy;

    /*
     * 전화번호
     */
    private String tel;

    /*
     * 콘텐츠명(제목)
     */
    private String title;

    /*
     * 홈페이지주소
     */
    private String homepage;

    /*
     * 대표이미지(원본)
     */
    private String firstimage;

    /*
     * 대표이미지(썸네일)
     */
    private String firstimage2;

    /*
     * 개요
     */
    private String overview;


}
