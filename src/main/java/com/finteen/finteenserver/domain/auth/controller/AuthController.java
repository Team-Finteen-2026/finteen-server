package com.finteen.finteenserver.domain.auth.controller;

import com.finteen.finteenserver.domain.auth.docs.AuthDocs;
import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RegisterRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.domain.auth.service.AuthService;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthDocs {
    private final AuthService authService;

    @PostMapping("/login")
    @Override
    public DataResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    @Override
    public Response register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}