package com.dw.dwtestserver01.restaurant.entity;

import com.dw.dwtestserver01.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="RESTAURANT")
public class RestaurantEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    @Column(nullable = false)
    private String name;
    @Column( nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String img_src;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String place;
}
