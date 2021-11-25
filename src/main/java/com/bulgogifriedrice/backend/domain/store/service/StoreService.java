package com.bulgogifriedrice.backend.domain.store.service;

import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.auth.repository.UserRepository;
import com.bulgogifriedrice.backend.domain.review.entity.Review;
import com.bulgogifriedrice.backend.domain.store.dto.StoreGetDto;
import com.bulgogifriedrice.backend.domain.store.dto.StoreRegisterDto;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import com.bulgogifriedrice.backend.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public void registerStore(StoreRegisterDto.Request request, String userEmail) {
        User user =  userRepository.findById(userEmail).get();
        Store store = Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .user(user)
                .build();
        storeRepository.save(store);
    }

    public List<StoreGetDto.Response> getStore() {
        return storeRepository.findAll().stream().map(
                a -> {
                    double avg = 0;
                    List<Review> reviewList = a.getReviewList();
                    long size = reviewList.size();
                    for (Review review : reviewList) {
                        avg = avg + review.getStarScore();
                    }
                    avg = avg / size;
                    return new StoreGetDto.Response(
                            a.getAddress(),
                            a.getName(),
                            avg,
                            size
                    );
                }
        ).collect(Collectors.toList());
    }
}
