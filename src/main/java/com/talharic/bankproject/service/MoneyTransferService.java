package com.talharic.bankproject.service;

import com.talharic.bankproject.converter.AccountMapper;
import com.talharic.bankproject.dto.MoneyTransferDto;
import com.talharic.bankproject.dto.MoneyTransferSaveRequestDto;
import com.talharic.bankproject.entity.MoneyTransfer;
import com.talharic.bankproject.service.entityservice.MoneyTransferEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MoneyTransferService {

    private final MoneyTransferEntityService moneyTransferEntityService;
    private final AccountActivityService accountActivityService;

    public MoneyTransferDto transferMoney(MoneyTransferSaveRequestDto moneyTransferSaveRequestDto){

        MoneyTransfer moneyTransfer = AccountMapper.INSTANCE.convertToMoneyTransfer(moneyTransferSaveRequestDto);

        Long accountIdFrom = moneyTransfer.getAccountIdFrom();
        Long accountIdTo = moneyTransfer.getAccountIdTo();
        BigDecimal amount = moneyTransfer.getAmount();

        accountActivityService.moneyOut(accountIdFrom, amount);
        accountActivityService.moneyIn(accountIdTo, amount);

        moneyTransfer = moneyTransferEntityService.save(moneyTransfer);

        MoneyTransferDto moneyTransferDto = AccountMapper.INSTANCE.convertToMoneyTransferDto(moneyTransfer);

        return moneyTransferDto;
    }
}
