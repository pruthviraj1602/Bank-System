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
    @Transient
    private Account account;

    @JsonManagedReference
    @OneToOne(mappedBy = "bankDetail",cascade = CascadeType.REMOVE)
    private bankLocation bankLocation;
}
