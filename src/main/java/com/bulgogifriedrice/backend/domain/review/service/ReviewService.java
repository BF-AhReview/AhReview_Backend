package com.bulgogifriedrice.backend.domain.review.service;

import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.auth.repository.UserRepository;
import com.bulgogifriedrice.backend.domain.review.dto.ReviewRegisterDto;
import com.bulgogifriedrice.backend.domain.review.entity.Picture;
import com.bulgogifriedrice.backend.domain.review.entity.Review;
import com.bulgogifriedrice.backend.domain.review.repository.PictureRepository;
import com.bulgogifriedrice.backend.domain.review.repository.ReviewRepository;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import com.bulgogifriedrice.backend.domain.store.repository.StoreRepository;
import com.bulgogifriedrice.backend.global.error.exception.StoreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final PictureRepository pictureRepository;

    public void registerReview(ReviewRegisterDto.Request request, String userEmail) {
        User user = userRepository.findById(userEmail).get();
        Store store = storeRepository.findById(request.getAddress())
                .orElseThrow(StoreNotFoundException::new);

        Review review = Review.builder()
                .reviewer(user)
                .store(store)
                .review(request.getReview())
                .answer(request.getAnswer())
                .positive(request.isPositive())
                .starScore(request.getStarScore())
                .anonymous(request.isAnonymous())
                .build();
        reviewRepository.save(review);

        request.getUrlList().forEach(
                url -> {
                    Picture picture = Picture.builder()
                            .review(review)
                            .url(url)
                            .build();
                    pictureRepository.save(picture);
                }
        );
    }
}