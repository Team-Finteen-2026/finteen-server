package com.finteen.finteenserver.domain.point.controller;

import com.finteen.finteenserver.domain.point.docs.PointDocs;
import com.finteen.finteenserver.domain.point.dto.response.PointResponse;
import com.finteen.finteenserver.domain.point.service.PointService;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
@RequiredArgsConstructor
public class PointController implements PointDocs {
    private final PointService pointService;

    @Override
    @GetMapping
    public DataResponse<PointResponse> getMyPoints() {
        return pointService.getMyPoints();
    }
}