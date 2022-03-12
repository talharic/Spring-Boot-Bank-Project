package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.Account;
import com.talharic.bankproject.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityService extends BaseEntityService<Account, AccountRepository> {
    public AccountEntityService(AccountRepository repository) {
        super(repository);
    }
}
