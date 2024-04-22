package com.bank.server.entiities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @OneToOne(mappedBy = "bankDetail",cascade = CascadeType.REMOVE)
    @JoinColumn(name="account_bankDetail")
    private Account account;

    @JsonManagedReference
    @OneToOne(mappedBy = "bankDetail",cascade = CascadeType.REMOVE)
    @JoinColumn(name="bankDetail_Location")
    private bankLocation bankLocation;
}
