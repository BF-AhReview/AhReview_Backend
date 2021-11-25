package com.bulgogifriedrice.backend.domain.auth.util.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NaverUserInfo {

    private String email;
    private String profileImage;
    private String name;

}
