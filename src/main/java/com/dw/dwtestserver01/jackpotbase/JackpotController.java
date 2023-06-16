package com.dw.dwtestserver01.jackpotbase;

import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jackpot")
public class JackpotController {

    private final JackpotService jackpotService;

    public JackpotController(JackpotService jackpotService) {
        this.jackpotService = jackpotService;
    }

    @GetMapping
    public ResponseEntity getAllMember(JackpotDto jackpotDto) {
        JackpotDto.Message jackpotMessage = jackpotService.jackpot(jackpotDto);
        return new ResponseEntity<>(
                new SingleResponseDto<>(jackpotMessage),
                HttpStatus.OK);
    }
}
