package com.dw.dwtestserver01.junket.entity;


import com.dw.dwtestserver01.account.entity.AccountEntity;
import com.dw.dwtestserver01.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Data;
import com.dw.dwtestserver01.common.audit.Auditable;

import java.util.List;


@Data
@Entity(name = "JUNKET")
public class JunketEntity extends Auditable {
    @Id
    @Column(length = 15)
    private String junketName;

    @OneToMany(mappedBy = "junketName")
    private List<MemberEntity> member;

    @OneToMany(mappedBy = "junketName")
    private List<AccountEntity> account;
}

