package com.bank.server.entiities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private float transactionAmount;
    private transactionStatus transactionStatus;
    private String transactionDate;
    private String transactionTime;

    @JsonBackReference
    @ManyToOne
    private Account account;
}
