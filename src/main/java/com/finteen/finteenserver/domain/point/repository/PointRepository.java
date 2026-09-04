package com.finteen.finteenserver.domain.point.repository;

import com.finteen.finteenserver.domain.point.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<PointEntity, Long> {
    PointEntity findByUserId(Long userId);
}