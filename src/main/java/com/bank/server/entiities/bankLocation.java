package com.bank.server.entiities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class bankLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankLocationId;
    private String city;
    private String state;
    private String country;

    @JsonBackReference
    @OneToOne
    private bankDetail bankDetail;
}
