package com.dw.dwtestserver01.Transaction.repository;

import com.dw.dwtestserver01.Transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<TransactionEntity> findByDwcode (String dwCode);
}
