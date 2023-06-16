package com.dw.dwtestserver01.account.service;

import com.dw.dwtestserver01.account.dto.AccountDto;
import com.dw.dwtestserver01.account.entity.AccountEntity;
import com.dw.dwtestserver01.account.mapper.AccountMapper;
import com.dw.dwtestserver01.account.repository.AccountRepository;
import com.dw.dwtestserver01.common.exception.BusinessLogicException;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountService (AccountRepository accountRepository,
                           AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountEntity createAccount (AccountDto.Post AccountPostDto){
        AccountEntity saveAccount = accountRepository.save(accountMapper.accountPostDto(AccountPostDto));
        return saveAccount;
    }

    public List<AccountEntity>  getAllAccount (AccountDto.Get getAccount){
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AccountEntity findVerifiedAccountByAccountNum ( String accountNum){
        Optional<AccountEntity> optionalAccount = accountRepository.findByAccountNum(accountNum);
        return optionalAccount.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ACCOUNT_NOT_FOUND));
    }

    public AccountEntity patchAccount(AccountDto.Patch patchAccount){
        AccountEntity update = accountMapper.patchAccount(patchAccount);
        AccountEntity updated = accountRepository.save(update);
        return updated;
    }


}
