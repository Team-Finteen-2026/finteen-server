package com.finteen.finteenserver.domain.user.exception;

import com.finteen.finteenserver.domain.user.exception.enums.UserErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException() {
        super(UserErrorCode.UNAUTHORIZED);
    }
}