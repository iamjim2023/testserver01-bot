package com.dw.dwtestserver01.member.repository;


import com.dw.dwtestserver01.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByAccountName(String accountName);


}

