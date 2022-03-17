package com.talharic.bankproject.controller;

import com.talharic.bankproject.dto.*;
import com.talharic.bankproject.service.AccountActivityService;
import com.talharic.bankproject.service.AccountService;
import com.talharic.bankproject.service.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final MoneyTransferService moneyTransferService;
    private final AccountActivityService accountActivityService;

    @GetMapping
    public ResponseEntity getAll(){

        List<AccountDto> accountDtoList = accountService.findAll();

        return ResponseEntity.ok(accountDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable  Long id){

        AccountDto accountDto = accountService.findById(id);

        return ResponseEntity.ok(accountDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AccountSaveRequestDto accountSaveRequestDto){

        AccountDto accountDto = accountService.save(accountSaveRequestDto);

        return ResponseEntity.ok(accountDto);
    }

    @PatchMapping("/cancel/{accountId}")
    public ResponseEntity cancel(@PathVariable Long accountId){

        accountService.cancel(accountId);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PostMapping("/money-transfer")
    public ResponseEntity transferMoney(@RequestBody MoneyTransferSaveRequestDto moneyTransferSaveRequestDto){

        MoneyTransferDto moneyTransferDto = moneyTransferService.transferMoney(moneyTransferSaveRequestDto);

        return ResponseEntity.ok(moneyTransferDto);
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody MoneyActivityRequestDto moneyActivityRequestDto){

        AccountActivityDto accountActivityDto = accountActivityService.withdraw(moneyActivityRequestDto);

        return ResponseEntity.ok(accountActivityDto);
    }

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody MoneyActivityRequestDto moneyActivityRequestDto){

        AccountActivityDto accountActivityDto = accountActivityService.deposit(moneyActivityRequestDto);

        return ResponseEntity.ok(accountActivityDto);
    }
}
