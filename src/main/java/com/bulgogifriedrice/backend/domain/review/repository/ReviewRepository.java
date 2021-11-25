package com.bulgogifriedrice.backend.domain.review.repository;

import com.bulgogifriedrice.backend.domain.review.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findByStoreAddressOrderByIdDesc(String store_address);
    List<Review> findByStoreAddressAndPositive(String store_address, boolean positive);

}
