package com.bank.server.controllers;

import com.bank.server.entiities.bankLocation;
import com.bank.server.services.userServiceIMPL.bankLocationServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankLocation")
public class bankLocationController {

    @Autowired
    public bankLocationServiceIMPL bankLocationIMPL;

    @PostMapping("/addBankLocation")
    public bankLocation addBankLocation(@RequestBody bankLocation bankLocation){
        return bankLocationIMPL.addBankLocation(bankLocation);
    }
}
