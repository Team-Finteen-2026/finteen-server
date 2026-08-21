package com.finteen.finteenserver.domain.user.repository;

import com.finteen.finteenserver.domain.user.entity.UserEntity;
import com.finteen.finteenserver.domain.user.enums.SocialProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findBySocialProviderTypeAndSocialProviderId(
            SocialProviderType socialProviderType,
            String socialProviderId
    );
}