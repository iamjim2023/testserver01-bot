package com.dw.dwtestserver01.member.mapper;


import com.dw.dwtestserver01.member.dto.MemberDto;
import com.dw.dwtestserver01.member.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberEntity memberPostDtoToMember(MemberDto.Post memberPostDto);

    MemberDto.Response memberToMemberResponse(MemberEntity createdMember);

    List<MemberDto.Get> getAllOfMember(List<MemberEntity> getMember);

    MemberDto.Get getMemberByAccountName(MemberEntity accountName);

}
