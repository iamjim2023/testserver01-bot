package com.dw.dwtestserver01.account.repository;

import com.dw.dwtestserver01.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByAccountNum(String accountNum);
}
