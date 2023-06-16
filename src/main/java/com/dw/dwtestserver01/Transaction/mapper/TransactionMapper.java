package com.dw.dwtestserver01.Transaction.mapper;


import com.dw.dwtestserver01.Transaction.dto.TransactionDto;
import com.dw.dwtestserver01.Transaction.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    TransactionEntity transacPostDto (TransactionDto.Post transacDto);

    TransactionDto.Response transacResDto (TransactionEntity createdTransaction);

    List<TransactionDto.Get> getAllTransac (List<TransactionEntity> getAllTransaction);

    TransactionDto.Get getTransacByCode (TransactionEntity getTransacByCode);

    TransactionEntity patchTransac(TransactionDto.Patch patchTransaction);
}
