package com.bank.server.repositories;

import com.bank.server.entiities.bankLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bankLocationRepository extends JpaRepository<bankLocation,Integer> {
}
