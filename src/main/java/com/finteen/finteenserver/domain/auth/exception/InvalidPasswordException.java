package com.finteen.finteenserver.domain.auth.exception;

import com.finteen.finteenserver.domain.auth.exception.enums.AuthErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException() {
        super(AuthErrorCode.INVALID_PASSWORD);
    }
}
