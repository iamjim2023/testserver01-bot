package com.dw.dwtestserver01.member.service;


import com.dw.dwtestserver01.common.exception.BusinessLogicException;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import com.dw.dwtestserver01.member.dto.MemberDto;
import com.dw.dwtestserver01.member.entity.MemberEntity;
import com.dw.dwtestserver01.member.mapper.MemberMapper;
import com.dw.dwtestserver01.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository,
                         MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }


    public MemberEntity createMember(MemberDto.Post memberPostDto) {
        MemberEntity savedMember = memberRepository.save(memberMapper.memberPostDtoToMember(memberPostDto));
        /*verifyExistAccountName(savedMember.getUserId());*/
        return savedMember;
    }

    public List<MemberEntity> getAllMember(MemberDto.Get getMember){

        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MemberEntity findVerifiedMemberByAccountName(String accountName) {
        Optional<MemberEntity> optionalMember = memberRepository.findByAccountName(accountName);
        return optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}
