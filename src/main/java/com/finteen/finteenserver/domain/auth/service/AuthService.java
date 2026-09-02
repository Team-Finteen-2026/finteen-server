package com.finteen.finteenserver.domain.auth.service;

import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RefreshRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RegisterRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.domain.auth.exception.InvalidPasswordException;
import com.finteen.finteenserver.domain.email.exception.EmailVerificationRequiredException;
import com.finteen.finteenserver.domain.user.entity.UserEntity;
import com.finteen.finteenserver.domain.user.enums.UserRoleType;
import com.finteen.finteenserver.domain.user.exception.UserNotFoundException;
import com.finteen.finteenserver.domain.user.repository.UserRepository;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import com.finteen.finteenserver.global.security.jwt.enums.JwtType;
import com.finteen.finteenserver.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;
    private final StringRedisTemplate redisTemplate;

    public DataResponse<TokenResponse> login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.email())
                .orElseThrow(UserNotFoundException::new);

        if (!bCryptPasswordEncoder.matches(
                request.password(),
                user.getPassword()
        )) {
            throw new InvalidPasswordException();
        }

        TokenResponse tokens = generateTokens(user.getId());

        return DataResponse.ok(
                "로그인 성공",
                tokens
        );
    }

    private TokenResponse generateTokens(Long userId) {
        String accessToken = jwtProvider.generate(
                userId,
                JwtType.ACCESS
        );

        String refreshToken = jwtProvider.generate(
                userId,
                JwtType.REFRESH
        );

        redisTemplate.opsForValue().set(
                "refresh:" + userId,
                refreshToken
        );

        return new TokenResponse(
                accessToken,
                refreshToken
        );
    }

    public Response register(RegisterRequest request) {
        String key = "email:verification:verified:" + request.email();

        if(!redisTemplate.hasKey(key)) {
            throw new EmailVerificationRequiredException();
        }

        UserEntity user = UserEntity.builder()
                .role(UserRoleType.USER)
                .email(request.email())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .name(request.name())
                .nickname(request.nickname())
                .gender(request.gender())
                .birth(request.birth())
                .build();

        userRepository.save(user);

        redisTemplate.delete(key);

        return Response.ok("회원가입 성공");
    }

    public DataResponse<TokenResponse> refresh(RefreshRequest request) {
        Long userId = jwtProvider.getUserId(
                request.refreshToken()
        );

        String accessToken = jwtProvider.generate(
                userId,
                JwtType.ACCESS
        );

        return DataResponse.ok(
                "토큰 재발급 성공",
                new TokenResponse(
                        accessToken,
                        request.refreshToken()
                )
        );
    }

    public Response logout() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        Long userId = (Long) authentication.getPrincipal();

        redisTemplate.delete(
                "refresh:" + userId
        );

        SecurityContextHolder.clearContext();

        return Response.ok("로그아웃 성공");
    }
}