package com.bulgogifriedrice.backend.domain.review.controller;

import com.bulgogifriedrice.backend.domain.review.dto.ReviewRegisterDto;
import com.bulgogifriedrice.backend.domain.review.service.ReviewService;
import com.bulgogifriedrice.backend.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping
    public void registerReview(@Valid @RequestBody ReviewRegisterDto.Request request) {
        reviewService.registerReview(request, authenticationFacade.getUserEmail());
    }

}
