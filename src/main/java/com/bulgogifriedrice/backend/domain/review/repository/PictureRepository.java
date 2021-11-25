package com.bulgogifriedrice.backend.domain.review.repository;

import com.bulgogifriedrice.backend.domain.review.entity.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture, Long> {
}
