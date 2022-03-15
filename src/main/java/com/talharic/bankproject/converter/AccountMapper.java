package com.talharic.bankproject.converter;

import com.talharic.bankproject.dto.AccountDto;
import com.talharic.bankproject.dto.AccountSaveRequestDto;
import com.talharic.bankproject.dto.MoneyTransferDto;
import com.talharic.bankproject.dto.MoneyTransferSaveRequestDto;
import com.talharic.bankproject.entity.Account;
import com.talharic.bankproject.entity.MoneyTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto convertToAccountDto(Account account);

    List<AccountDto> convertToAccountDtoList(List<Account> accountList);

    Account convertToAccount(AccountSaveRequestDto accountSaveRequestDto);

    MoneyTransfer convertToMoneyTransfer(MoneyTransferSaveRequestDto moneyTransferSaveRequestDto);

    MoneyTransferDto convertToMoneyTransferDto(MoneyTransfer moneyTransfer);
}
