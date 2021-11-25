package com.bulgogifriedrice.backend.domain.review.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ReviewRegisterDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "리뷰 등록 request", description = "리뷰 등록 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "가게 주소", example = "울릉도")
        private String address;

        @ApiModelProperty(value = "가게 별점", example = "5.0")
        private double starScore;

        @ApiModelProperty(value = "리뷰 익명 여부", example = "true")
        private boolean anonymous;

        @ApiModelProperty(value = "리뷰 긍정 여부", example = "true")
        private boolean positive;

        @NotBlank
        @ApiModelProperty(value = "가게 리뷰", example = "넘 좋아요")
        private String review;

        @NotBlank
        @ApiModelProperty(value = "챗봇 반응", example = "넘 좋아요")
        private String answer;

        @ApiModelProperty(value = "가게 사진 url 리스트", example = "[\"asdfasdfas.com\",\"asdfasdfas.com\"]")
        private List<String> urlList;

    }

}
