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
        @ApiModelProperty(value = "네이버 code", example = "naverCode")
        private String address;

    }

}
