package com.bulgogifriedrice.backend.domain.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "네이버 code 로그인 request", description = "네이버 로그인 request")
    public static class CodeRequest {

        @NotBlank
        @ApiModelProperty(value = "네이버 code", example = "naverCode")
        private String code;

    }

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "네이버 token 로그인 request", description = "네이버 로그인 request")
    public static class TokenRequest {

        @NotBlank
        @ApiModelProperty(value = "네이버 access token", example = "naver access token")
        private String accessToken;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "네이버 로그인 response", description = "네이버 로그인 response")
    public static class Response {

        @ApiModelProperty(value = "access 토큰", example = "accessToken")
        private String accessToken;

        @ApiModelProperty(value = "refresh 토큰", example = "refreshToken")
        private String refreshToken;

    }

}
