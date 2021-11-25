package com.bulgogifriedrice.backend.domain.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class StoreRegisterDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "가게 등록 request", description = "가게 등록 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "가게 주소", example = "한라산")
        private String address;

        @NotBlank
        @ApiModelProperty(value = "가게 이름", example = "백두산 막창 전골")
        private String name;

        @NotBlank
        @ApiModelProperty(value = "가게 사진 url", example = "qmffkqmfdkm.com")
        private String url;

    }

}
