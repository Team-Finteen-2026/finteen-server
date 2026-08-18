package com.finteen.finteenserver.domain.user.entity;

import com.finteen.finteenserver.domain.user.enums.RoleType;
import com.finteen.finteenserver.domain.user.enums.SocialType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    private String socialId;

    private String name;

    private String email;

    private String nickname;

    private String bio;

    private String profileImage;

    private LocalDate birth;

    private LocalDate createdAt;
}