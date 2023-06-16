package com.dw.dwtestserver01.member.entity;

import com.dw.dwtestserver01.common.audit.Auditable;
import com.dw.dwtestserver01.junket.entity.JunketEntity;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name="MEMBER")

public class MemberEntity extends Auditable {
    @Id
    @Column
    private String accountName;

    @Column
    private String email;

    @Column
    private String employeeCode;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String phone;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "junketName")
    private JunketEntity junketName;
}
