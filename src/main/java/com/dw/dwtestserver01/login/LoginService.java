package com.dw.dwtestserver01.login;



import com.dw.dwtestserver01.member.entity.MemberEntity;
import com.dw.dwtestserver01.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LoginService {
    private final MemberRepository memberRepository;


    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    public LoginDto.Post Login(LoginDto.Post logindto) {

        Optional<MemberEntity> optionalMember =  memberRepository.findByAccountName(logindto.getAccountName());

        if (optionalMember.isEmpty()) {
            throw new RuntimeException("Member Does Not Exist.");
        }
        MemberEntity foundMember = optionalMember.orElseThrow();
        if (!logindto.getPassword().equals(foundMember.getPassword())) {
            throw new RuntimeException("Password mismatch.");
        }
        return logindto;
    }
}
