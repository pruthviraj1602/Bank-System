package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.Transaction;
import com.bank.server.entiities.transactionStatus;
import com.bank.server.repositories.accountRepository;
import com.bank.server.repositories.transactionRepository;
import com.bank.server.services.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Service
public class transactionServiceIMPL implements transactionService {

    @Autowired
    public transactionRepository transactionRepo;
    
    @Autowired
    public accountRepository accountRepo;


    @Override
    public Transaction addtransaction(Transaction transaction) {
        transaction.setTransactionTime(LocalTime.now().toString());
        transaction.setTransactionDate(LocalDate.now().toString());
        Integer accountId=transaction.getAccount().getAccountId();
        Account account=accountRepo.getAccountByAccountId(accountId);
        float availableAmount=account.getAccountBalance();
        if(Objects.equals(transaction.getTransactionStatus(), transactionStatus.CREDITED)){
            float totalAmount=availableAmount + transaction.getTransactionAmount();
            account.setAccountBalance(totalAmount);
            accountRepo.save(account);
            return transactionRepo.save(transaction);
        } else if (Objects.equals(transaction.getTransactionStatus(),transactionStatus.DEBITED)) {
            float totalAmount=availableAmount - transaction.getTransactionAmount();
            if(availableAmount>transaction.getTransactionAmount()){
                account.setAccountBalance(totalAmount);
                accountRepo.save(account);
                return transactionRepo.save(transaction);
            }

        }
        return transaction;

    }
}
