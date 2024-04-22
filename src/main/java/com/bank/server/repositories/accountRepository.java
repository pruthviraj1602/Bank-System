package com.bank.server.repositories;

import com.bank.server.entiities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<Account,Integer> {

   public Account getAccountByAccountId(Integer accountId);
}
