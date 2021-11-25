package com.bulgogifriedrice.backend.domain.auth.controller;

import com.bulgogifriedrice.backend.domain.auth.dto.LoginDto;
import com.bulgogifriedrice.backend.domain.auth.dto.TokenRefreshDto;
import com.bulgogifriedrice.backend.domain.auth.service.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login/code")
    @ApiOperation(value = "네이버 oauth 로그인", notes = "네이버 oauth code를 받아서 로그인합니다")
    public LoginDto.Response loginByCode(@Valid @RequestBody LoginDto.CodeRequest request) {
        return authService.loginByCode(request);
    }

    @PostMapping("/login/token")
    @ApiOperation(value = "네이버 oauth 로그인", notes = "네이버 oauth token를 받아서 로그인합니다")
    public LoginDto.Response loginByToken(@Valid @RequestBody LoginDto.TokenRequest request) {
        return authService.loginByToken(request.getAccessToken());
    }

    @PostMapping("/token-refresh")
    @ApiOperation(value = "토큰 리프레쉬", notes = "리프레쉬 토큰을 받아서 액세스 토큰을 반환합니다")
    public TokenRefreshDto.Response tokenRefresh(@Valid @RequestBody TokenRefreshDto.Request request) {
        return authService.tokenRefresh(request);
    }

}
