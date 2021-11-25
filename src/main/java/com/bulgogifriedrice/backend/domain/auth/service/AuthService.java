package com.bulgogifriedrice.backend.domain.auth.service;

import com.bulgogifriedrice.backend.domain.auth.dto.LoginDto;
import com.bulgogifriedrice.backend.domain.auth.dto.TokenRefreshDto;
import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.auth.repository.UserRepository;
import com.bulgogifriedrice.backend.domain.auth.util.api.client.NaverTokenClient;
import com.bulgogifriedrice.backend.domain.auth.util.api.client.NaverUserClient;
import com.bulgogifriedrice.backend.domain.auth.util.api.dto.NaverUserInfo;
import com.bulgogifriedrice.backend.global.error.exception.InvalidCodeException;
import com.bulgogifriedrice.backend.global.error.exception.InvalidTokenException;
import com.bulgogifriedrice.backend.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final NaverTokenClient naverTokenClient;
    private final NaverUserClient naverUserClient;

    @Value("${auth.api.id}")
    private String clientId;

    @Value("${auth.api.secret}")
    private String clientSecret;

    @Value("${auth.api.state}")
    private String state;

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginDto.Response login(LoginDto.Request request) {
        String token = naverTokenClient.getToken(
                "authorization_code",
                clientId,
                clientSecret,
                request.getCode(),
                state
                ).getAccessToken();

        if (token == null) {
            throw new InvalidCodeException();
        }

        NaverUserInfo userInfo = naverUserClient.getToken("Bearer " + token).getResponse();

        String email = userInfo.getEmail();
        if (!userRepository.existsById(email)) {
            User user = User.builder()
                    .email(email)
                    .profile(userInfo.getProfileImage())
                    .name(userInfo.getName())
                    .build();
            userRepository.save(user);
        } else {
            User user = userRepository.findById(email).get();
            user.updateInfo(userInfo.getProfileImage(), userInfo.getName());
        }

        String accessToken = jwtTokenProvider.generateAccessToken(email);
        String refreshToken = jwtTokenProvider.generateRefreshToken(email);

        return new LoginDto.Response(accessToken, refreshToken);
    }

    public TokenRefreshDto.Response tokenRefresh(TokenRefreshDto.Request request) {
        String refreshToken = request.getRefreshToken();

        if (jwtTokenProvider.validateRefreshToken(refreshToken)) {
            String id = jwtTokenProvider.getId(refreshToken);
            if (userRepository.existsById(id)) {
                String accessToken = jwtTokenProvider.generateAccessToken(id);
                return new TokenRefreshDto.Response(accessToken);
            }
        }
        throw new InvalidTokenException();
    }
}
