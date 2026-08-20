package com.finteen.finteenserver.domain.auth.controller;

import com.finteen.finteenserver.domain.auth.docs.AuthDocs;
import com.finteen.finteenserver.domain.auth.service.AuthService;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthDocs {
    private final AuthService authService;

    @PostMapping("/logout")
    public Response logout() {
        authService.logout();

        return Response.ok("로그아웃 성공");
    }
}