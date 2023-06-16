package com.dw.dwtestserver01.account.mapper;

import com.dw.dwtestserver01.account.dto.AccountDto;
import com.dw.dwtestserver01.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountEntity accountPostDto(AccountDto.Post accountPostDto);

    AccountDto.Response accountResdto(AccountEntity createdAccount);

    List<AccountDto.Get> getAllAccount (List<AccountEntity> getAllAccount);

    AccountDto.Get getAccountByAccountNum (AccountEntity getByAccountNum);

    AccountEntity patchAccount (AccountDto.Patch patchAccountDto);
}
