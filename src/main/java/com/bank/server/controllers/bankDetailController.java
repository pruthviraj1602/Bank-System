package com.bank.server.controllers;

import com.bank.server.entiities.bankDetail;
import com.bank.server.services.userServiceIMPL.bankDetailServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankDetail")
public class bankDetailController {
    @Autowired
    public bankDetailServiceIMPL bankDetailIMPL;

    @PostMapping("/addBankDetail")
    public bankDetail addBankDetail(@RequestBody bankDetail bankDetail){
        return bankDetailIMPL.addBankDetail(bankDetail);
    }
}
