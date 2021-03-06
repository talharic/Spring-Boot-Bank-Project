package com.talharic.bankproject.service;

import com.talharic.bankproject.converter.AccountMapper;
import com.talharic.bankproject.dto.AccountActivityDto;
import com.talharic.bankproject.dto.MoneyActivityRequestDto;
import com.talharic.bankproject.entity.Account;
import com.talharic.bankproject.entity.AccountActivity;
import com.talharic.bankproject.enums.AccountActivityType;
import com.talharic.bankproject.enums.AccountErrorMessage;
import com.talharic.bankproject.exception.BusinessException;
import com.talharic.bankproject.service.entityservice.AccountActivityEntityService;
import com.talharic.bankproject.service.entityservice.AccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccountActivityService {

    private final AccountEntityService accountEntityService;
    private final AccountActivityEntityService accountActivityEntityService;

    public AccountActivityDto withdraw(MoneyActivityRequestDto moneyWithdrawRequestDto) {

        Long accountId = moneyWithdrawRequestDto.getAccountId();
        BigDecimal amount = moneyWithdrawRequestDto.getAmount();

        AccountActivity accountActivity = moneyOut(accountId, amount, AccountActivityType.WITHDRAW);

        AccountActivityDto accountActivityDto = AccountMapper.INSTANCE.convertToAccountActivityDto(accountActivity);

        return accountActivityDto;
    }

    public AccountActivityDto deposit(MoneyActivityRequestDto moneyWithdrawRequestDto) {

        Long accountId = moneyWithdrawRequestDto.getAccountId();
        BigDecimal amount = moneyWithdrawRequestDto.getAmount();

        AccountActivity accountActivity = moneyIn(accountId, amount, AccountActivityType.DEPOSIT);

        AccountActivityDto accountActivityDto = AccountMapper.INSTANCE.convertToAccountActivityDto(accountActivity);

        return accountActivityDto;
    }

    public AccountActivity moneyOut(Long accountId, BigDecimal amount, AccountActivityType accountActivityType) {

        Account account = accountEntityService.getByIdWithControl(accountId);

        BigDecimal newBalance = account.getCurrentBalance().subtract(amount);

        validateBalance(newBalance);

        AccountActivity accountActivity = createAccountActivity(accountId, amount, newBalance, accountActivityType);

        updateCurrentBalance(account, newBalance);

        return accountActivity;
    }

    public AccountActivity moneyIn(Long accountId, BigDecimal amount, AccountActivityType accountActivityType) {

        Account account = accountEntityService.getByIdWithControl(accountId);

        BigDecimal newBalance = account.getCurrentBalance().add(amount);

        AccountActivity accountActivity = createAccountActivity(accountId, amount, newBalance, accountActivityType);

        updateCurrentBalance(account, newBalance);

        return accountActivity;
    }

    private AccountActivity createAccountActivity(Long accountId, BigDecimal amount, BigDecimal newBalance, AccountActivityType accountActivityType) {
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.setAccountActivityType(AccountActivityType.SEND);
        accountActivity.setAccountId(accountId);
        accountActivity.setAmount(amount);
        accountActivity.setTransactionDate(new Date());
        accountActivity.setCurrentBalance(newBalance);
        accountActivity = accountActivityEntityService.save(accountActivity);
        return accountActivity;
    }

    private void updateCurrentBalance(Account account, BigDecimal newBalance) {
        account.setCurrentBalance(newBalance);
        account = accountEntityService.save(account);
    }

    private void validateBalance(BigDecimal newBalance) {
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new BusinessException(AccountErrorMessage.INSUFFICIENT_BALANCE);
        }
    }
}
