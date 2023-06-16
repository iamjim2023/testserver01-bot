package com.dw.dwtestserver01.member.controller;


import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import com.dw.dwtestserver01.member.dto.MemberDto;
import com.dw.dwtestserver01.member.entity.MemberEntity;
import com.dw.dwtestserver01.member.mapper.MemberMapper;
import com.dw.dwtestserver01.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,
                            MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto) {
        MemberEntity member = memberService.createMember(memberPostDto);
        MemberDto.Response response = memberMapper.memberToMemberResponse(member);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getAllMember(MemberDto.Get getMember){
        List <MemberEntity> member = memberService.getAllMember(getMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(memberMapper.getAllOfMember(member)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{accountName}")
    public ResponseEntity getMember(@PathVariable("accountName") String accountName) {
        MemberEntity member = memberService.findVerifiedMemberByAccountName(accountName);
        return new ResponseEntity<>(
                new SingleResponseDto<>(memberMapper.getMemberByAccountName(
                        member)),
                HttpStatus.OK
        );

    }

}
