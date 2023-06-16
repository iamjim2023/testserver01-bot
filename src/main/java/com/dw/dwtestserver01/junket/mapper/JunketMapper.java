package com.dw.dwtestserver01.junket.mapper;

import com.dw.dwtestserver01.junket.dto.JunketDto;
import com.dw.dwtestserver01.junket.entity.JunketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JunketMapper {
    JunketEntity junketPostToJunket(JunketDto.Post junketPostDto);
    JunketEntity junketPatchToJunket(JunketDto.Patch junketPatchDto);

    JunketDto.Response junketToJunketResponse(JunketEntity junket);

    List<JunketDto.Response> junketsToJunketsResponse(List<JunketEntity> junkets);
}
