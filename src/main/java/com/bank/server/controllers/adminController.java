package com.bank.server.controllers;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.entiities.bankDetail;
import com.bank.server.security.Authentication;
import com.bank.server.services.userServiceIMPL.accountServiceIMPL;
import com.bank.server.services.userServiceIMPL.bankDetailServiceIMPL;
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
    public Authentication authentication;
    @Autowired
    public userServiceIMPL userIMPL;
    @Autowired
    public accountServiceIMPL accountIMPL;
    @Autowired
    public bankDetailServiceIMPL bankIMPL;



    @PostMapping("/enableUser/{customerId}")
    public User setEnable(@PathVariable Integer customerId){
        boolean b = authentication.authorized();
        if(b) {
            return userIMPL.setEnable(customerId);
        }
        return null;
    }

    @PostMapping("/enableAccount/{accountNumber}")
    public Account setEnableUser(@PathVariable String accountNumber){
        boolean b = authentication.authorized();
        if(b) {
            return accountIMPL.setEnableAccount(accountNumber);
        }
        return null;
    }

    @PostMapping("/getBankDetail/{branchId}")
    public bankDetail getBankDetailByBranchId(@PathVariable Integer branchId){
        return bankIMPL.getBankDetailByBranchId(branchId);
    }
}
