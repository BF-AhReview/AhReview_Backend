package com.bulgogifriedrice.backend.domain.auth.controller;

import com.bulgogifriedrice.backend.domain.auth.dto.UserInfoDto;
import com.bulgogifriedrice.backend.domain.auth.service.MypageService;
import com.bulgogifriedrice.backend.global.security.AuthenticationFacade;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MypageController {

    private final MypageService mypageService;
    private final AuthenticationFacade authenticationFacade;

    @GetMapping("/info")
    @ApiOperation(value = "유저 정보 가져오기", notes = "유저 정보를 가져옵니다")
    public UserInfoDto.Response getUserInfo() {
        return mypageService.getUserInfo(authenticationFacade.getUserEmail());
    }

}
