package com.dw.dwtestserver01.account.dto;

import com.dw.dwtestserver01.junket.entity.JunketEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;


import java.time.LocalDate;

public class AccountDto {

    @Getter
    public static class Post{
        @NotBlank
        private String accountNum;

        @NotBlank
        private LocalDate birthDate;

        @NotBlank
        private int cny;

        @NotBlank
        private int hdk;

        @NotBlank
        private String name;

        @NotBlank
        private LocalDate passportExp;

        @NotBlank
        private String passportImg;

        @NotBlank
        private String passportNum;

        @NotBlank
        private String password;

        @NotBlank
        private String phone01;

        @NotBlank
        private String phone02;

        @NotBlank
        private String phone03;

        @NotBlank
        private int php;

        @NotBlank
        private String Remarks;

        @NotBlank
        private String sex;

        @NotBlank
        private String status;

        @NotBlank
        private int usdt;

        @NotBlank
        private JunketEntity junketName;
    }

    @Data
    public static class Response{
        @NotBlank
        private String accountNum;

        @NotBlank
        private LocalDate birthDate;

        @NotBlank
        private int cny;

        @NotBlank
        private int hdk;

        @NotBlank
        private String name;

        @NotBlank
        private LocalDate passportExp;

        @NotBlank
        private String passportImg;

        @NotBlank
        private String passportNum;

        @NotBlank
        private String password;

        @NotBlank
        private String phone01;

        @NotBlank
        private String phone02;

        @NotBlank
        private String phone03;

        @NotBlank
        private int php;

        @NotBlank
        private String Remarks;

        @NotBlank
        private String sex;

        @NotBlank
        private String status;

        @NotBlank
        private int usdt;

        @NotBlank
        private JunketEntity junketName;
    }

    @Data
    public static class Get{
        @NotBlank
        private String accountNum;

        @NotBlank
        private LocalDate birthDate;

        @NotBlank
        private int cny;

        @NotBlank
        private int hdk;

        @NotBlank
        private String name;

        @NotBlank
        private LocalDate passportExp;

        @NotBlank
        private String passportImg;

        @NotBlank
        private String passportNum;

        @NotBlank
        private String password;

        @NotBlank
        private String phone01;

        @NotBlank
        private String phone02;

        @NotBlank
        private String phone03;

        @NotBlank
        private int php;

        @NotBlank
        private String Remarks;

        @NotBlank
        private String sex;

        @NotBlank
        private String status;

        @NotBlank
        private int usdt;

        @NotBlank
        private JunketEntity junketName;
    }

    @Getter
    public static class Patch{
        @NotBlank
        private String accountNum;

        @NotBlank
        private LocalDate birthDate;

        @NotBlank
        private int cny;

        @NotBlank
        private int hdk;

        @NotBlank
        private String name;

        @NotBlank
        private LocalDate passportExp;

        @NotBlank
        private String passportImg;

        @NotBlank
        private String passportNum;

        @NotBlank
        private String password;

        @NotBlank
        private String phone01;

        @NotBlank
        private String phone02;

        @NotBlank
        private String phone03;

        @NotBlank
        private int php;

        @NotBlank
        private String Remarks;

        @NotBlank
        private String sex;

        @NotBlank
        private String status;

        @NotBlank
        private int usdt;

        @NotBlank
        private JunketEntity junketName;
    }
}
