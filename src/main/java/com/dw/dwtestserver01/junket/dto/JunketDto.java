package com.dw.dwtestserver01.junket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;


public class JunketDto {
    @Getter
    public static class Post {

        @NotBlank
        private String junketName;

    }

    @Data
    public static class Response {
        @NotBlank
        private String junketName;
    }

    @Getter
    public static class Patch {
        @NotBlank
        private String junketName;
    }
}
