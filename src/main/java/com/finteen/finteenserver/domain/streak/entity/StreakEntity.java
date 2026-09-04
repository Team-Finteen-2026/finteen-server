package com.finteen.finteenserver.domain.streak.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "streaks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StreakEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}