package com.dw.dwtestserver01.Transaction.dto;

import com.dw.dwtestserver01.account.entity.AccountEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

public class TransactionDto {


    @Getter
    public static class Post {
        @NotBlank
        private String dwcode;
        @NotBlank
        private int amount;
        @NotBlank
        private String currency;
        @NotBlank
        private String type;
        @NotBlank
        private AccountEntity accountNum;
    }

    @Data
    public static class Response {
        @NotBlank
        private String dwcode;
        @NotBlank
        private int amount;
        @NotBlank
        private String currency;
        @NotBlank
        private String type;
        @NotBlank
        private AccountEntity accountNum;
    }

    @Data
    public static class Get {
        @NotBlank
        private String dwcode;
        @NotBlank
        private int amount;
        @NotBlank
        private String currency;
        @NotBlank
        private String type;
        @NotBlank
        private AccountEntity accountNum;
    }

    @Getter
    public static class Patch {
        @NotBlank
        private String dwcode;
        @NotBlank
        private int amount;
        @NotBlank
        private String currency;
        @NotBlank
        private String type;
        @NotBlank
        private AccountEntity accountNum;
    }

}
