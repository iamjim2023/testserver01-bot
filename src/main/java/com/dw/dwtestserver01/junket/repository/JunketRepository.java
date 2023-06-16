package com.dw.dwtestserver01.junket.repository;

import com.dw.dwtestserver01.junket.entity.JunketEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JunketRepository extends JpaRepository<JunketEntity, Long>{
}
