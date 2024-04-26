package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.Transaction;
import com.bank.server.entiities.User;
import com.bank.server.entiities.transactionStatus;
import com.bank.server.repositories.accountRepository;
import com.bank.server.repositories.transactionRepository;
import com.bank.server.services.transactionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Service
public class transactionServiceIMPL implements transactionService {

    @Autowired
    HttpSession session;
    @Autowired
    public transactionRepository transactionRepo;

    @Autowired
    public userServiceIMPL userIMPL;
    @Autowired
    public accountRepository accountRepo;
    @Autowired
    public emailServiceIMPL emailService;


    @Override
    public Transaction addtransaction(Transaction transaction) {
        transaction.setTransactionTime(LocalTime.now().toString());
        transaction.setTransactionDate(LocalDate.now().toString());
        Integer accountId=transaction.getAccount().getAccountId();
        Account account=accountRepo.getAccountByAccountId(accountId);
        float availableAmount = account.getAccountBalance();
        if(account.isEnable()) {
            if (Objects.equals(transaction.getTransactionStatus(), transactionStatus.CREDITED)) {

                float totalAmount = availableAmount + transaction.getTransactionAmount();
                account.setAccountBalance(totalAmount);
                session.setAttribute("account",account);
                session.setAttribute("transaction",transaction);
                int customerId = account.getUser().getCustomerId();
                User userId = userIMPL.getUserByCustomerId(customerId);
                emailService.sendMail(userId.getCustomerEmail(), "OTP Verification");
//                accountRepo.save(account);
//                transactionRepo.save(transaction);

                return null;
            } else if (Objects.equals(transaction.getTransactionStatus(), transactionStatus.DEBITED)) {
                float totalAmount = availableAmount - transaction.getTransactionAmount();
                if (availableAmount > transaction.getTransactionAmount()) {
                    account.setAccountBalance(totalAmount);
                    Integer customerId = account.getUser().getCustomerId();
                    User userId = userIMPL.getUserByCustomerId(customerId);
                    session.setAttribute("account",account);
                    session.setAttribute("transaction",transaction);

                    emailService.sendMail(userId.getCustomerEmail(), "OTP Verification");
//                    accountRepo.save(account);
//                     transactionRepo.save(transaction);
                }

            }
        }
        return transaction;

    }

    @Override
    public boolean verifyTransactionWithOTP(String otp) {
        Account acc = (Account) session.getAttribute("account");
        Transaction tra = (Transaction) session.getAttribute("transaction");
        boolean b = emailService.verifyOtp(otp);
        if(b){
            accountRepo.save(acc);
            transactionRepo.save(tra);
            return true;
        }
        return false;
    }


}
