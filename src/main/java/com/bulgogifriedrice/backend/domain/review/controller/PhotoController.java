package com.bulgogifriedrice.backend.domain.review.controller;

import com.bulgogifriedrice.backend.domain.review.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photo")
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable(value = "id") long id) throws SQLException {
        byte[] photo = photoService.getPhoto(id);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "image/png");

        return new ResponseEntity<byte[]>
                (photo, header, HttpStatus.OK);
    }

}
