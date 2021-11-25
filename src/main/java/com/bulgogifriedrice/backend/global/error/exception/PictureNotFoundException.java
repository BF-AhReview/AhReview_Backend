package com.bulgogifriedrice.backend.global.error.exception;

import com.bulgogifriedrice.backend.global.error.ErrorCode;

public class PictureNotFoundException extends GlobalException {

    public PictureNotFoundException() {
        super(ErrorCode.PICTURE_NOT_FOUND);
    }

}
