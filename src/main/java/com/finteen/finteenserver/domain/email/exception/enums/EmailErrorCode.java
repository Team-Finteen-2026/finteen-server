package com.finteen.finteenserver.domain.email.exception.enums;

import com.finteen.finteenserver.global.common.exception.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EmailErrorCode implements BaseErrorCode {
    INVALID_VERIFICATION_CODE(HttpStatus.BAD_REQUEST, "인증 코드가 올바르지 않습니다."),
    VERIFICATION_CODE_EXPIRED(HttpStatus.BAD_REQUEST, "만료된 인증 코드입니다.");

    private final HttpStatus status;
    private final String message;
}