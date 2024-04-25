package com.bank.server.controllers;

import com.bank.server.entiities.Account;
import com.bank.server.security.Authentication;
import com.bank.server.services.userServiceIMPL.accountServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class accountController {

    @Autowired
    public accountServiceIMPL accountIMPL;
    @Autowired
    public Authentication authentication;

    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account){
        boolean b = authentication.authorized();
        if(b){
            return accountIMPL.addAccount(account);
        }
       return null;
    }
}
