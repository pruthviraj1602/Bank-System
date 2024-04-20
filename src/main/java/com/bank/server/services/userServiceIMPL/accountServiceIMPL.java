package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.repositories.accountRepository;
import com.bank.server.services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class accountServiceIMPL implements accountService {

    @Autowired
    public accountRepository accountRepo;
    @Override
    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }
}
