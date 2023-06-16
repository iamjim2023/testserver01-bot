package com.dw.dwtestserver01.restaurant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

public class RestaurantDto {
    @Getter
    public static class Post {
        @NotBlank
        private String name;
        @NotBlank
        private String nickName;
        @NotBlank
        private String img_src;
        @NotBlank
        private String email;
        @NotBlank
        private String phone;
        @NotBlank
        private String place;
    }

    @Data
    public static class Response {
        @NotBlank
        private String name;
        @NotBlank
        private String nickName;
        @NotBlank
        private String img_src;
        @NotBlank
        private String email;
        @NotBlank
        private String phone;
        @NotBlank
        private String place;
    }

    @Data
    public static class Get {
        @NotBlank
        private String name;
        @NotBlank
        private String nickName;
        @NotBlank
        private String img_src;
        @NotBlank
        private String email;
        @NotBlank
        private String phone;
        @NotBlank
        private String place;
    }

    @Getter
    public static class Patch {
        @NotNull
        private Long restaurantId;
        @NotBlank
        private String name;
        @NotBlank
        private String nickName;
        @NotBlank
        private String img_src;
        @NotBlank
        private String email;
        @NotBlank
        private String phone;
        @NotBlank
        private String place;
    }
}
