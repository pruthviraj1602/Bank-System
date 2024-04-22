package com.bank.server.controllers;

import com.bank.server.entiities.Transaction;
import com.bank.server.services.userServiceIMPL.transactionServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class transactionController {

    @Autowired
    public transactionServiceIMPL transactionIMPL;
    @PostMapping("/transaction")
    public Transaction addtransaction(@RequestBody Transaction transaction){
        return transactionIMPL.addtransaction(transaction);
    }
}
