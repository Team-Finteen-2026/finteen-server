package com.finteen.finteenserver.domain.user.exception;

import com.finteen.finteenserver.domain.user.exception.enums.UserErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}