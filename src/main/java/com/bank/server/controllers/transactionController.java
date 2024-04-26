package com.bank.server.controllers;

import com.bank.server.entiities.OTP;
import com.bank.server.entiities.Transaction;
import com.bank.server.services.userServiceIMPL.transactionServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class transactionController {

    @Autowired
    public transactionServiceIMPL transactionIMPL;

    @PostMapping("/transactionInitiate")
    public Transaction addtransaction(@RequestBody Transaction transaction){
        return transactionIMPL.addtransaction(transaction);
    }

    @GetMapping("/transactionOTP")
    public ResponseEntity<?> makeTransaction(@RequestBody OTP otp){
        boolean b = transactionIMPL.verifyTransactionWithOTP(otp.getOtp());
        if(b){
            return ResponseEntity.ok("Transaction Successfully");
        }
        return ResponseEntity.ok("Transaction Failed!!");
    }


}
