package com.finteen.finteenserver.domain.auth.service;

import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RegisterRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.domain.auth.exception.EmailAlreadyExistsException;
import com.finteen.finteenserver.domain.auth.exception.InvalidPasswordException;
import com.finteen.finteenserver.domain.user.entity.UserEntity;
import com.finteen.finteenserver.domain.user.enums.UserRoleType;
import com.finteen.finteenserver.domain.user.exception.UserNotFoundException;
import com.finteen.finteenserver.domain.user.repository.UserRepository;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import com.finteen.finteenserver.global.security.jwt.enums.JwtType;
import com.finteen.finteenserver.global.security.jwt.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;

    public DataResponse<TokenResponse> login(
            LoginRequest request
    ) {
        UserEntity user = userRepository.findByEmail(request.email())
                .orElseThrow(UserNotFoundException::new);

        if (!bCryptPasswordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        return DataResponse.ok(
                "로그인 성공",
                generateTokens(user.getId())
        );
    }

    private TokenResponse generateTokens(Long userId) {
        return new TokenResponse(
                jwtProvider.generate(userId, JwtType.ACCESS),
                jwtProvider.generate(userId, JwtType.REFRESH)
        );
    }

    public Response register(
            RegisterRequest request
    ) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException();
        }

        UserEntity user = UserEntity.builder()
                .role(UserRoleType.USER)
                .email(request.email())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .nickname(request.nickname())
                .gender(request.gender())
                .birth(request.birth()).build();

        userRepository.save(user);

        return Response.ok("회원가입 성공");
    }
}