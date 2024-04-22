package com.bank.server.repositories;

import com.bank.server.entiities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepository extends JpaRepository<Transaction,Integer> {

}
