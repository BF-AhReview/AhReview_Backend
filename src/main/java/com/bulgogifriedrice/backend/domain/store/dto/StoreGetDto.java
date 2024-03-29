package com.bulgogifriedrice.backend.domain.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class StoreGetDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "가게 가져오기 response", description = "가게 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "가게 주소", example = "제주도")
        private String address;

        @ApiModelProperty(value = "가게 이름", example = "길동이네 소주팔이")
        private String name;

        @ApiModelProperty(value = "가게 사진 url", example = "sdfsdf.com")
        private String url;

        @ApiModelProperty(value = "가게 별점", example = "5.0")
        private double starScore;

        @ApiModelProperty(value = "가게 리뷰 수", example = "100")
        private long reviewAmount;

    }

}
