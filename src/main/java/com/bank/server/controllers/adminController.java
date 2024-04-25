package com.bank.server.controllers;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.services.userServiceIMPL.accountServiceIMPL;
import com.bank.server.services.userServiceIMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class adminController {

    @Autowired
    public userServiceIMPL userIMPL;
    @Autowired
    public accountServiceIMPL accountIMPL;


    @PostMapping("/enableUser/{customerId}")
    public User setEnable(@PathVariable Integer customerId){

        return userIMPL.setEnable(customerId);
    }

    @PostMapping("/enableAccount/{accountNumber}")
    public Account setEnableUser(@PathVariable String accountNumber){
        return accountIMPL.setEnableUser(accountNumber);
    }
}
