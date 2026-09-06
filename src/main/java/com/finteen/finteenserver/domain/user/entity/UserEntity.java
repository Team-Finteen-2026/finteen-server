package com.finteen.finteenserver.domain.user.entity;

import com.finteen.finteenserver.domain.user.enums.UserRole;
import com.finteen.finteenserver.domain.user.enums.SocialProvider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private SocialProvider provider;

    private String providerId;

    @Column(nullable = false)
    private String nickname;

    private String profileImage;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public UserEntity(
            UserRole role,
            String email,
            String password,
            SocialProvider provider,
            String providerId,
            String nickname,
            String profileImage
    ) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.nickname = nickname;
        this.profileImage = profileImage;
    }

    @PrePersist
    protected void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}