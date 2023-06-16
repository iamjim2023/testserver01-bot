package com.dw.dwtestserver01.restaurant.repository;

import com.dw.dwtestserver01.restaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
