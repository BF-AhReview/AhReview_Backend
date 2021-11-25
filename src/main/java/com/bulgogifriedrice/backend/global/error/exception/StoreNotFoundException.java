package com.bulgogifriedrice.backend.global.error.exception;

import com.bulgogifriedrice.backend.global.error.ErrorCode;

public class StoreNotFoundException extends GlobalException {

    public StoreNotFoundException() {
        super(ErrorCode.STORE_NOT_FOUND);
    }

}
