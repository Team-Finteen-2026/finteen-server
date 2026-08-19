package com.finteen.finteenserver.global.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class Response {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public static Response ok(String message) {
        return Response.builder()
                .status(HttpStatus.OK)
                .message(message)
                .build();
    }
}