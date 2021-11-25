package com.bulgogifriedrice.backend.domain.review.service;

import com.bulgogifriedrice.backend.domain.review.repository.PictureRepository;
import com.bulgogifriedrice.backend.global.error.exception.PictureNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PictureRepository pictureRepository;

    public byte[] getPhoto(long id) throws SQLException {
        Blob blob = pictureRepository.findById(id)
                .orElseThrow(PictureNotFoundException::new)
                .getPhoto();
        return blob.getBytes(0, (int) blob.length());
    }
}
