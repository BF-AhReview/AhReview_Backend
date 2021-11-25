package com.bulgogifriedrice.backend.domain.auth.service;

import com.bulgogifriedrice.backend.domain.auth.dto.UserInfoDto;
import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.auth.repository.UserRepository;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final UserRepository userRepository;

    public UserInfoDto.Response getUserInfo(String userEmail) {
        User user = userRepository.findById(userEmail).get();
        return new UserInfoDto.Response(
                user.getEmail(),
                user.getProfile(),
                user.getName(),
                user.getStoreList().stream().map(
                        Store::getAddress
                ).collect(Collectors.toList())
        );
    }
}
