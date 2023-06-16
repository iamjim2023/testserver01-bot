package com.dw.dwtestserver01.Transaction.service;

import com.dw.dwtestserver01.Transaction.dto.TransactionDto;
import com.dw.dwtestserver01.Transaction.entity.TransactionEntity;
import com.dw.dwtestserver01.Transaction.mapper.TransactionMapper;
import com.dw.dwtestserver01.Transaction.repository.TransactionRepository;
import com.dw.dwtestserver01.common.exception.BusinessLogicException;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository,
                              TransactionMapper transactionMapper){
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }


     public TransactionEntity createTransac (TransactionDto.Post transacPost){
        TransactionEntity saveTransac = transactionRepository.save(transactionMapper.transacPostDto(transacPost));
        return saveTransac;
     }

     public List<TransactionEntity> getAllTransac (TransactionDto.Get getTransac){
        return transactionRepository.findAll();
    }


     @Transactional(readOnly = true)
    public TransactionEntity findVerifiedTransacByDwCode(String dwCode){
         Optional<TransactionEntity> optionalTransaction = transactionRepository.findByDwcode(dwCode);
         return optionalTransaction.orElseThrow(() ->
                 new BusinessLogicException(ExceptionCode.ACCOUNT_NOT_FOUND));

     }

     public TransactionEntity patchTransac(TransactionDto.Patch patchTransac){
        TransactionEntity update = transactionMapper.patchTransac(patchTransac);
        TransactionEntity updated = transactionRepository.save(update);
        return update;
     }
}
