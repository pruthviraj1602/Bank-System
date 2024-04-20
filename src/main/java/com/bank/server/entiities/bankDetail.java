package com.bank.server.entiities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class bankDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    private String bankName;
    private String bankIFSC;

    @OneToOne(mappedBy = "bankDetail",cascade = CascadeType.REMOVE)
    @JoinColumn(name="account_bankDetail")
    private Account account;

    @OneToOne(mappedBy = "bankDetail",cascade = CascadeType.REMOVE)
    @JoinColumn(name="bankDetail_Location")
    private bankLocation bankLocation;
}
