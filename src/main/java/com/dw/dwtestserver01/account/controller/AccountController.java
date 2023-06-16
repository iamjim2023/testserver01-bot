package com.dw.dwtestserver01.account.controller;


import com.dw.dwtestserver01.account.dto.AccountDto;
import com.dw.dwtestserver01.account.entity.AccountEntity;
import com.dw.dwtestserver01.account.mapper.AccountMapper;
import com.dw.dwtestserver01.account.service.AccountService;
import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    public AccountController(AccountService accountService,
                             AccountMapper accountMapper){
        this.accountService=accountService;
        this.accountMapper =accountMapper;
    }

    @PostMapping
    public ResponseEntity postAccount(@Valid @RequestBody AccountDto.Post AccountPostDto){
        AccountEntity account = accountService.createAccount(AccountPostDto);
        AccountDto.Response response = accountMapper.accountResdto(account);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getAllAccount(AccountDto.Get getAccount){
        List<AccountEntity> account = accountService.getAllAccount(getAccount);
        return new ResponseEntity<>(
                new SingleResponseDto<>(accountMapper.getAllAccount(account)),
                HttpStatus.OK
        );
    }

    @GetMapping("/accountNum")
    public ResponseEntity getOneAccount(@PathVariable("accountNum") String accountNum){
        AccountEntity account = accountService.findVerifiedAccountByAccountNum(accountNum);
        return new ResponseEntity<>(
                new SingleResponseDto<>(accountMapper.getAccountByAccountNum(
                        account)),
                HttpStatus.OK
        );
    }

    @PatchMapping
    public ResponseEntity patchAccount(@RequestBody AccountDto.Patch patchAccount){
        AccountEntity result = accountService.patchAccount(patchAccount);
        return  new ResponseEntity<>(
                new SingleResponseDto<>(result),
                HttpStatus.ACCEPTED
        );
    }
}
