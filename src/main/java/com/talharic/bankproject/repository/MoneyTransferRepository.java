package com.talharic.bankproject.repository;

import com.talharic.bankproject.entity.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Long> {
}
