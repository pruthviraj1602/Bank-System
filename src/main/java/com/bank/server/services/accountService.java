package com.bank.server.services;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface accountService {
    public Account addAccount(Account account);
    public Account getAccountByAccountNumber(String accountNumber);

    public Account setEnableAccount(String accountNumber);


}
