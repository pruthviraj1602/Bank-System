package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.repositories.accountRepository;
import com.bank.server.repositories.userRepository;
import com.bank.server.services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class accountServiceIMPL implements accountService {

    @Autowired
    public accountRepository accountRepo;

    @Autowired
    public userRepository userRepo;

    @Override
    public Account addAccount(Account account) {
        Integer customerId = account.getUser().getCustomerId();
        User userId = userRepo.getUserByCustomerId(customerId);
        if (userId.isEnable()){
            account.setEnable(false);
            return accountRepo.save(account);
        }

       return null;
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepo.getAccountByAccountNumber(accountNumber);
    }

    @Override
    public Account setEnableUser(String accountNumber) {
        Account acc = accountRepo.getAccountByAccountNumber(accountNumber);
      if (acc!=null){
          acc.setEnable(true);
          return accountRepo.save(acc);
      }
        return null;
    }
}
