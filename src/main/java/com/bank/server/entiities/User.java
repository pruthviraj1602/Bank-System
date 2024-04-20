package com.bank.server.entiities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String CustomerName;
    @Column(unique = true)
    private String customerContact;
    @Column(unique = true)
    private String customerEmail;
    private String customerPassword;
    private String loginData;
    private String logoutTime;

    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_account")
    @JsonManagedReference
    private Account account;


}
