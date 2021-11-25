package com.bulgogifriedrice.backend.domain.auth.controller;

import com.bulgogifriedrice.backend.domain.auth.dto.LoginDto;
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

    @PostMapping("/login")
    @ApiOperation(value = "네이버 oauth 로그인", notes = "네이버 oauth code를 받아서 로그인합니다")
    public LoginDto.Response login(@Valid @RequestBody LoginDto.Request request) {
        return authService.login(request);
    }

}
