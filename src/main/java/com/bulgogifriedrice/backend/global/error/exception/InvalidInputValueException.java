package com.bulgogifriedrice.backend.global.error.exception;

import com.bulgogifriedrice.backend.global.error.ErrorCode;

public class InvalidInputValueException extends GlobalException {

    public InvalidInputValueException() {
        super(ErrorCode.INVALID_INPUT_VALUE);
    }

}
