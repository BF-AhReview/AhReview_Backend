package com.bulgogifriedrice.backend.global.error.exception;

import com.bulgogifriedrice.backend.global.error.ErrorCode;

public class InvalidTokenException extends GlobalException{

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}