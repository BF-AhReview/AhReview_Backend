package com.bulgogifriedrice.backend.domain.auth.util.api.client;

import com.bulgogifriedrice.backend.domain.auth.util.api.dto.NaverTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "naverTokenClient", url = "https://nid.naver.com/oauth2.0")
public interface NaverTokenClient {

    @PostMapping("/token")
    NaverTokenResponse getToken(@RequestParam("grant_type") String grantType,
                                @RequestParam("client_id") String clientId,
                                @RequestParam("client_secret") String clientSecret,
                                @RequestParam("code") String code,
                                @RequestParam("state") String state);

}
