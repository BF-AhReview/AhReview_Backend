package com.bulgogifriedrice.backend.domain.auth.util.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NaverUserResponse {

    @JsonProperty("response")
    private NaverUserInfo response;

}
