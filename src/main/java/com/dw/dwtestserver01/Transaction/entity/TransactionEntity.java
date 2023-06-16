package com.dw.dwtestserver01.Transaction.entity;


import com.dw.dwtestserver01.account.entity.AccountEntity;
import com.dw.dwtestserver01.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "DEPOSITWITHDRAWAL")
public class TransactionEntity extends Auditable {

    @Id
    private String dwcode;

    @Column
    private int amount;

    @Column
    private String currency;

    @Column
    private String type;

    @OneToOne
    @JoinColumn(name = "accountNum")
    private AccountEntity accountNum;

}
