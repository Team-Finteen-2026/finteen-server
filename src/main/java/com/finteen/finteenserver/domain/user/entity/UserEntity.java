package com.finteen.finteenserver.domain.user.entity;

import com.finteen.finteenserver.domain.user.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleType role;
}