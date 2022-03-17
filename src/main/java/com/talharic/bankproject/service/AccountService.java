package com.talharic.bankproject.service;

import com.talharic.bankproject.converter.AccountMapper;
import com.talharic.bankproject.dto.AccountDto;
import com.talharic.bankproject.dto.AccountSaveRequestDto;
import com.talharic.bankproject.entity.Account;
import com.talharic.bankproject.enums.StatusType;
import com.talharic.bankproject.service.entityservice.AccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountEntityService accountEntityService;


    public List<AccountDto> findAll() {

        List<Account> accountList = accountEntityService.findAll();

        List<AccountDto> accountDtoList = AccountMapper.INSTANCE.convertToAccountDtoList(accountList);

        return accountDtoList;
    }

    public AccountDto findById(Long id) {

        Account account = accountEntityService.getByIdWithControl(id);

        AccountDto accountDto = AccountMapper.INSTANCE.convertToAccountDto(account);

        return accountDto;
    }

    public AccountDto save(AccountSaveRequestDto accountSaveRequestDto) {

        Account account = AccountMapper.INSTANCE.convertToAccount(accountSaveRequestDto);

        account.setStatusType(StatusType.ACTIVE);

        account  = accountEntityService.save(account);

        AccountDto accountDto = AccountMapper.INSTANCE.convertToAccountDto(account);

        return accountDto;
    }

    public void cancel(Long accountId) {

        Account account = accountEntityService.getByIdWithControl(accountId);
        account.setStatusType(StatusType.PASSIVE);

        accountEntityService.save(account);
    }
}
