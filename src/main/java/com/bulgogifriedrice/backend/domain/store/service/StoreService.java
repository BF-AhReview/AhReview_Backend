package com.bulgogifriedrice.backend.domain.store.service;

import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.auth.repository.UserRepository;
import com.bulgogifriedrice.backend.domain.store.dto.StoreRegisterDto;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import com.bulgogifriedrice.backend.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public void registerStore(StoreRegisterDto.Request request, String userEmail) {
        User user =  userRepository.findById(userEmail).get();
        Store store = Store.builder()
                .address(request.getAddress())
                .user(user)
                .build();
        storeRepository.save(store);
    }
}
