package com.bank.server.services;

import com.bank.server.entiities.Transaction;
import jakarta.servlet.http.HttpSession;

public interface transactionService {

    public Transaction addtransaction(Transaction transaction);

    public boolean verifyTransactionWithOTP(String otp);
}
