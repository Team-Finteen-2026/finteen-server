package com.finteen.finteenserver.domain.point.docs;

import com.finteen.finteenserver.domain.point.dto.response.PointResponse;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Point", description = "사용자 포인트 조회 및 관리")
public interface PointDocs {
    @Operation(
            summary = "포인트 조회",
            description = "현재 로그인한 사용자의 포인트를 조회합니다."
    )
    DataResponse<PointResponse> getPoints();
}