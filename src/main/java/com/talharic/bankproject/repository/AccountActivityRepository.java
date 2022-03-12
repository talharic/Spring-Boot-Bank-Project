package com.talharic.bankproject.repository;

import com.talharic.bankproject.entity.AccountActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountActivityRepository extends JpaRepository<AccountActivity, Long> {
}
