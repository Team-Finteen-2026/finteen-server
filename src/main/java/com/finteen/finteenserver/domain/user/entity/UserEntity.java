package com.finteen.finteenserver.domain.user.entity;

import com.finteen.finteenserver.domain.user.enums.RoleType;
import com.finteen.finteenserver.domain.user.enums.SocialProviderType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialProviderType socialProviderType;

    private String socialProviderId;

    @Column(nullable = false, unique = true)
    private String username;

    private String name;

    private String nickname;

    private String email;

    private String bio;

    private String profileImage;

    private LocalDate birth;

    private LocalDate createdAt;
}