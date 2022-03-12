package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.MoneyTransfer;
import com.talharic.bankproject.repository.MoneyTransferRepository;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferEntityService extends BaseEntityService<MoneyTransfer, MoneyTransferRepository> {
    public MoneyTransferEntityService(MoneyTransferRepository repository) {
        super(repository);
    }
}
