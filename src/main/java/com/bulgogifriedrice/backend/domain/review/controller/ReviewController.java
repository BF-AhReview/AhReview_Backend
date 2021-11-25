package com.bulgogifriedrice.backend.domain.review.controller;

import com.bulgogifriedrice.backend.domain.review.dto.ReviewGetDto;
import com.bulgogifriedrice.backend.domain.review.dto.ReviewRegisterDto;
import com.bulgogifriedrice.backend.domain.review.service.ReviewService;
import com.bulgogifriedrice.backend.global.error.exception.InvalidInputValueException;
import com.bulgogifriedrice.backend.global.security.AuthenticationFacade;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping
    @ApiOperation(value = "리뷰 등록", notes = "리뷰를 등록합니다")
    public void registerReview(@Valid @RequestBody ReviewRegisterDto.Request request) {
        reviewService.registerReview(request, authenticationFacade.getUserEmail());
    }

    @GetMapping
    @ApiOperation(value = "리뷰 가져오기", notes = "filter에 조건을 넣으세요. 1 -> 최신순 / 2 -> 긍정 / 3 -> 부정")
    public List<ReviewGetDto.Response> getReview(@RequestParam("filter") int filter, @RequestParam("address") String address) {
        if (filter == 1) {
            return reviewService.getReviewLatest(address);
        } else if (filter == 2) {
            return reviewService.getReviewPositive(address);
        } else if (filter == 3) {
            return reviewService.getReviewNegative(address);
        } else {
            throw new InvalidInputValueException();
        }
    }

}
