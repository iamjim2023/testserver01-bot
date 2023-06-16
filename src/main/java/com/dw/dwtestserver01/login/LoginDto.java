package com.dw.dwtestserver01.login;

import jakarta.persistence.Lob;
import jakarta.persistence.PostLoad;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Loader;

@Getter
public class LoginDto {
    @Data
    public static class Post {
        @NotBlank
        private String accountName;
        @NotBlank
        private String password;

    }
}
