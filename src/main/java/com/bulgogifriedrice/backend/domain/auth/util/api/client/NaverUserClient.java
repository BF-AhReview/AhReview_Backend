package com.bulgogifriedrice.backend.domain.auth.util.api.client;

import com.bulgogifriedrice.backend.domain.auth.util.api.dto.NaverUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "naverUserClient", url = "https://openapi.naver.com/v1/nid")
public interface NaverUserClient {

    @GetMapping("/me")
    NaverUserResponse getToken(@RequestHeader("Authorization") String value);

}
