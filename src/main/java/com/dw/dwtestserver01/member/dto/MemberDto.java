package com.dw.dwtestserver01.member.dto;

import com.dw.dwtestserver01.junket.entity.JunketEntity;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class MemberDto {

    @Getter
    public static class Post {
        @NotBlank
        private String accountName;
        @NotBlank
        private String email;
        @NotBlank
        private String employee_code;
        @NotBlank
        private String name;
        @NotBlank
        private String password;
        @NotBlank
        private String phone;
        @NotBlank
        private List<String> roles = new ArrayList<>();
        @NotBlank
        private JunketEntity junketName;
    }
    @Data
    public static class Response {

        @NotBlank
        private String accountName;
        @NotBlank
        private String email;
        @NotBlank
        private String employee_code;
        @NotBlank
        private String name;
        @NotBlank
        private String password;
        @NotBlank
        private String phone;
        @NotBlank
        private List<String> roles = new ArrayList<>();
        @NotBlank
        private JunketEntity junketName;
    }

    @Data
    public static class Get {
        @NotBlank
        private String accountName;
        @NotBlank
        private String email;
        @NotBlank
        private String employee_code;
        @NotBlank
        private String name;
        @NotBlank
        private String phone;
        @NotBlank
        private List<String> roles = new ArrayList<>();
        @NotBlank
        private JunketEntity junketName;

    }

    @Data
    public static class Login {
        @NotBlank
        private String accountName;
        @NotBlank
        private String password;
    }
}
