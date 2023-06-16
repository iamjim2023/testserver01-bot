package com.dw.dwtestserver01.Transaction.controller;


import com.dw.dwtestserver01.Transaction.dto.TransactionDto;
import com.dw.dwtestserver01.Transaction.entity.TransactionEntity;
import com.dw.dwtestserver01.Transaction.mapper.TransactionMapper;
import com.dw.dwtestserver01.Transaction.service.TransactionService;
import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    private final TransactionMapper transactionMapper;

    public TransactionController(TransactionService transactionService,
                                 TransactionMapper transactionMapper ){
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping
    public ResponseEntity postTransac(@Valid @RequestBody TransactionDto.Post transacPostDto){
        TransactionEntity transac = transactionService.createTransac(transacPostDto);
        TransactionDto.Response response = transactionMapper.transacResDto(transac);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getAllTransac(TransactionDto.Get getTransac){
        List<TransactionEntity> transaction = transactionService.getAllTransac(getTransac);
        return new ResponseEntity<>(
                new SingleResponseDto<>(transactionMapper.getAllTransac(transaction)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{dwcode}")
    public ResponseEntity getOneTransac(@PathVariable("dwcode") String dwcode){
        TransactionEntity transac = transactionService.findVerifiedTransacByDwCode(dwcode);
        return new ResponseEntity<>(
                new SingleResponseDto<>(transactionMapper.getTransacByCode(
                        transac)),
                HttpStatus.OK
        );
    }

    @PatchMapping
    public ResponseEntity patchTrans(@RequestBody TransactionDto.Patch patchTransac){
        TransactionEntity result = transactionService.patchTransac(patchTransac);
        return  new ResponseEntity<>(
                new SingleResponseDto<>(result),
                HttpStatus.ACCEPTED
        );
    }
}
