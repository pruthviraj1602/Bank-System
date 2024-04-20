package com.bank.server.entiities;

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
    private String transactionStatus;
    private String transactionDate;
    private String transactionTime;

    @ManyToOne
    private Account account;
}
