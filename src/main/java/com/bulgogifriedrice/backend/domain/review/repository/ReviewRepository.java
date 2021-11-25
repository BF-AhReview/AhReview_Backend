package com.bulgogifriedrice.backend.domain.review.repository;

import com.bulgogifriedrice.backend.domain.review.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
