package com.finteen.finteenserver.domain.auth.service;

import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.domain.user.entity.UserEntity;
import com.finteen.finteenserver.domain.user.repository.UserRepository;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public DataResponse<TokenResponse> login(LoginRequest request) {

    }
}