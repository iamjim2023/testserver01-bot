package com.dw.dwtestserver01.jackpotbase;

import lombok.Data;

import java.util.List;

public class JackpotDto {
    @Data
    public static class Message {
        private String Code;
        private String Msg;
        private List<Jackpot> jackpots;
    }

    @Data
    public static class Jackpot {
        private long jackpotId;
        private long value;
        private long maxHit;
        private long minHit;
    }
}
