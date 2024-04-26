package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.bankDetail;
import com.bank.server.repositories.bankDetailRepository;
import com.bank.server.services.bankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bankDetailServiceIMPL implements bankDetailService {
    @Autowired
    public bankDetailRepository bankDetailRepo;

    @Override
    public bankDetail addBankDetail(bankDetail bankDetail) {
        return bankDetailRepo.save(bankDetail);
    }

    @Override
    public bankDetail getBankDetailByBranchId(Integer branchId) {
        return bankDetailRepo.getBankDetailByBranchId(branchId);
    }
}
