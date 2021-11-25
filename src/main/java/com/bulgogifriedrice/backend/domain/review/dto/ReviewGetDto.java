package com.bulgogifriedrice.backend.domain.review.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ReviewGetDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "리뷰 가져오기 response", description = "리뷰 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "가게 별점", example = "5.0")
        private double starScore;

        @ApiModelProperty(value = "유저명", example = "익명일 경우 null")
        private String username;

        @ApiModelProperty(value = "리뷰 긍정 여부", example = "true")
        private boolean positive;

        @ApiModelProperty(value = "가게 리뷰", example = "넘 좋아요")
        private String review;

        @ApiModelProperty(value = "챗봇 반응", example = "넘 좋아요")
        private String answer;

        @ApiModelProperty(value = "가게 사진 url 리스트", example = "[\"asdfasdfas.com\",\"asdfasdfas.com\"]")
        private List<String> urlList;

    }

}
