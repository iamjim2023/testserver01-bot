package com.dw.dwtestserver01.jackpotbase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class JackpotService {

    public JackpotDto.Message jackpot(JackpotDto jackpotDto) {

        JackpotDto.Message newJackpotMessageDto = new JackpotDto.Message();
        newJackpotMessageDto.setCode("0");
        newJackpotMessageDto.setMsg("Successful");
        List<JackpotDto.Jackpot> newJackpot = new ArrayList<>();

        for (Long i = 1L; i <= 6; i++) {
            JackpotDto.Jackpot generatedJackpot = new JackpotDto.Jackpot();
            generatedJackpot.setJackpotId(i);

            if (i == 1) {
                generatedJackpot.setMinHit(520000L);
                generatedJackpot.setMaxHit(600000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }
            if (i == 2) {
                generatedJackpot.setMinHit(2500000L);
                generatedJackpot.setMaxHit(4088000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }
            if (i == 3) {
                generatedJackpot.setMinHit(4500000L);
                generatedJackpot.setMaxHit(7088000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }
            if (i == 4) {
                generatedJackpot.setMinHit(9500000L);
                generatedJackpot.setMaxHit(11088000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }
            if (i == 5) {
                generatedJackpot.setMinHit(19500000L);
                generatedJackpot.setMaxHit(21088000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }
            if (i == 6) {
                generatedJackpot.setMinHit(49888000L);
                generatedJackpot.setMaxHit(53888000L);
                generatedJackpot.setValue((long) (Math.random() * (generatedJackpot.getMaxHit() -
                        generatedJackpot.getMinHit()) + generatedJackpot.getMinHit()));
            }

            newJackpot.add(generatedJackpot);
        }
        newJackpotMessageDto.setJackpots(newJackpot);
        return newJackpotMessageDto;
    }
}
