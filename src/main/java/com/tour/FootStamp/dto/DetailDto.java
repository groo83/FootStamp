package com.tour.FootStamp.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@JsonNaming
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailDto extends CommonDto {
    /*
     * 교과서여행지여부 (1=여행지, 0=해당없음)
     */
    private String booktour;

    /*
     * 콘텐츠 최초 등록일
     */
    private String createdtime;

    /*
     * 홈페이지
     */
    private String homepage;

    /*
     * 수정일
     */
    private String modifiedtime;

    /*
     * 전화번호명
     */
    private String telname;

    /*
     * 저작권 유형
     */
    private String cpyrhtDivCd;

    /*
     * Map Level
     */
    private String mlevel;


}
