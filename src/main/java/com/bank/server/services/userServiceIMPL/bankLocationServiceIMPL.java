package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.bankLocation;
import com.bank.server.repositories.bankLocationRepository;
import com.bank.server.services.bankLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bankLocationServiceIMPL implements bankLocationService {

    @Autowired
    public bankLocationRepository bankLocationRepo;

    @Override
    public bankLocation addBankLocation(bankLocation bankLocation) {
        return bankLocationRepo.save(bankLocation);
    }
}
