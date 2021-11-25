package com.bulgogifriedrice.backend.domain.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class UserInfoDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "유저 정보 response", description = "유저 정보 response")
    public static class Response {

        @ApiModelProperty(value = "유저 email", example = "iamhong@josun.com")
        private String email;

        @ApiModelProperty(value = "유저 profile 사진 링크", example = "iamhong.com")
        private String profile;

        @ApiModelProperty(value = "유저 이름", example = "홍길동")
        private String name;
        
        private List<StoreInfo> storeList;

        private List<ReviewInfo> reviewInfoList;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "유저 가게 정보 response", description = "유저 가게 response")
    public static class StoreInfo {

        @ApiModelProperty(value = "가게 주소", example = "제주도")
        private String address;

        @ApiModelProperty(value = "가게 이름", example = "홍길동네 감귤")
        private String name;

        @ApiModelProperty(value = "가게 사진 url", example = "ddsfsdfs.com")
        private String url;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "리뷰 정보 response", description = "리뷰 정보 response")
    public static class ReviewInfo {

        @ApiModelProperty(value = "가게 주소", example = "제주도")
        private String address;

        @ApiModelProperty(value = "가게 이름", example = "돌하르방 손맛 칼국수")
        private String name;

        @ApiModelProperty(value = "가게 사진 url", example = "asdfasdf.com")
        private String url;

        @ApiModelProperty(value = "가게 별점", example = "5.0")
        private double starScore;

        @ApiModelProperty(value = "가게 리뷰", example = "동에 번쩍 서에 번쩍")
        private String review;

    }

}
