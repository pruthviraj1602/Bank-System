package com.bank.server.services;

import com.bank.server.entiities.bankDetail;

public interface bankDetailService {
    public bankDetail addBankDetail(bankDetail bankDetail);

    public bankDetail getBankDetailByBranchId(Integer branchId);
}
