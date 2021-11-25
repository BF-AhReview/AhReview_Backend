package com.bulgogifriedrice.backend.global.error.exception;

import com.bulgogifriedrice.backend.global.error.ErrorCode;

public class InvalidCodeException extends GlobalException {

    public InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }

}
