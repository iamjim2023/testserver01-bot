package com.dw.dwtestserver01.account.entity;


import com.dw.dwtestserver01.common.audit.Auditable;
import com.dw.dwtestserver01.junket.entity.JunketEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity(name="ACCOUNT")
public class AccountEntity extends Auditable {

    @Id
    @Column(length = 15)
    private String accountNum;

    @Column
    @DateTimeFormat
    private LocalDate birthDate;

    @Column
    private int cny;

    @Column
    private int hdk;

    @Column
    private String name;

    @Column
    private LocalDate passportExp;

    @Column(length = 150)
    private String passportImg;

    @Column(length = 15)
    private String passportNum;

    @Column(length = 10)
    private String password;

    @Column(length = 15)
    private String phone01;

    @Column(length = 15)
    private String phone02;

    @Column(length = 15)
    private String phone03;

    @Column
    private int php;

    @Column
    private String Remarks;

    @Column(length = 3)
    private String sex;

    @Column(length = 15)
    private String status;

    @Column
    private int usdt;

    @ManyToOne
    @JoinColumn(name = "junketName")
    private JunketEntity junketName;

}
