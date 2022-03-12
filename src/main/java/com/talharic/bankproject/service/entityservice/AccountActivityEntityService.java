package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.AccountActivity;
import com.talharic.bankproject.repository.AccountActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountActivityEntityService extends BaseEntityService<AccountActivity, AccountActivityRepository> {

    public AccountActivityEntityService(AccountActivityRepository repository) {
        super(repository);
    }
}
