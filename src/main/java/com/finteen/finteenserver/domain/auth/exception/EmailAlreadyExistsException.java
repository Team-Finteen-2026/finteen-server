package com.finteen.finteenserver.domain.auth.exception;

import com.finteen.finteenserver.domain.auth.exception.enums.AuthErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class EmailAlreadyExistsException extends BaseException {
    public EmailAlreadyExistsException() {
        super(AuthErrorCode.EMAIL_ALREADY_EXISTS);
    }
}