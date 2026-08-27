package com.finteen.finteenserver.domain.email.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EmailSendRequest(
        @NotBlank
        String email
) {
}