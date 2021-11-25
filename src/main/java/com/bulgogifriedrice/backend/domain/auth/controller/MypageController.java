package com.bulgogifriedrice.backend.domain.auth.controller;

import com.bulgogifriedrice.backend.domain.auth.dto.UserInfoDto;
import com.bulgogifriedrice.backend.domain.auth.service.MypageService;
import com.bulgogifriedrice.backend.global.security.AuthenticationFacade;
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
    public UserInfoDto.Response getUserInfo() {
        return mypageService.getUserInfo(authenticationFacade.getUserEmail());
    }

}
