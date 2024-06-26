package com.bank.server.repositories;

import com.bank.server.entiities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
    public User getUserByCustomerId(Integer customerId);

    public User getUserByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword);

    @Transactional
    public Integer deleteUserByCustomerId(Integer customerId);
    }