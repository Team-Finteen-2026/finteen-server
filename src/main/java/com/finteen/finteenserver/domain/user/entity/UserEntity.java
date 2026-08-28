package com.finteen.finteenserver.domain.user.entity;

import com.finteen.finteenserver.domain.user.enums.GenderType;
import com.finteen.finteenserver.domain.user.enums.UserRoleType;
import com.finteen.finteenserver.domain.user.enums.SocialProviderType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleType role;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private SocialProviderType socialProviderType;

    private String socialProviderId;

    private String name;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private LocalDate birth;

    private String profileImage;

    @Builder
    public UserEntity(
            UserRoleType role,
            String email,
            String password,
            SocialProviderType socialProviderType,
            String socialProviderId,
            String name,
            String nickname,
            GenderType gender,
            LocalDate birth,
            String profileImage
    ) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.socialProviderType = socialProviderType;
        this.socialProviderId = socialProviderId;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.birth = birth;
        this.profileImage = profileImage;
    }
}