package com.finteen.finteenserver.global.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class DataResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public static <T> DataResponse<T> ok(String message, T data) {
        return DataResponse.<T>builder()
                .status(HttpStatus.OK)
                .message(message)
                .data(data)
                .build();
    }
}