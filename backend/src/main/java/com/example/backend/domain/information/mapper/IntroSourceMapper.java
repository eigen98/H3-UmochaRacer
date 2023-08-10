package com.example.backend.domain.information.mapper;

import com.example.backend.domain.information.dto.ColorInformationResponse;
import com.example.backend.domain.information.dto.CommonResponse;
import com.example.backend.domain.information.dto.IntroResponse;
import com.example.backend.domain.information.model.car.entity.ExteriorColor;
import com.example.backend.domain.information.model.car.entity.InteriorColor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class IntroSourceMapper {
    public CommonResponse map(ExteriorColor exteriorColor) {
        return ColorInformationResponse.builder()
                .name(exteriorColor.getBaseInfo().getName())
                .imageSrc(exteriorColor.getColorCode())
                .build();
    }
    public CommonResponse map(InteriorColor interiorColor) {
        return ColorInformationResponse.builder()
                .name(interiorColor.getBaseInfo().getName())
                .imageSrc(interiorColor.getIconSrc())
                .build();
    }

    public List<IntroResponse> mapToResponse(Map<String, List<CommonResponse>> data) {
        return data.entrySet().stream()
                .map(entry -> new IntroResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
