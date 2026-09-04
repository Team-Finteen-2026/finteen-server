package com.finteen.finteenserver.domain.point.service;

import com.finteen.finteenserver.domain.point.dto.response.PointResponse;
import com.finteen.finteenserver.domain.point.entity.PointEntity;
import com.finteen.finteenserver.domain.point.repository.PointRepository;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.security.jwt.utils.UserAuthenticationHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {
    private final UserAuthenticationHolder userAuthenticationHolder;
    private final PointRepository pointRepository;

    public DataResponse<PointResponse> getPoints() {
        Long userId = userAuthenticationHolder.getUserId();
        PointEntity point = pointRepository.findByUserId(userId);

        return DataResponse.ok(
                "포인트 조회 성공",
                new PointResponse(point.getPoint())
        );
    }
}