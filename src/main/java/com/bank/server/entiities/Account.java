package com.bank.server.entiities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column(unique = true)
    private String accountNumber;
    private float accountBalance;

    @OneToOne
    @JsonBackReference
    private User user;

   @OneToOne
    private bankDetail bankDetail;

   @OneToMany(mappedBy = "account",cascade = CascadeType.REMOVE)
   private List<Transaction> transactions;
}
