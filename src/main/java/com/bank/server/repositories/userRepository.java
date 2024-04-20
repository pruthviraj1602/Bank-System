package com.bank.server.repositories;

import com.bank.server.entiities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
    public User getUserByCustomerId(Integer customerId);
}
