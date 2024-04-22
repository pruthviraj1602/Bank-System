package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.User;
import com.bank.server.repositories.userRepository;
import com.bank.server.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class userServiceIMPL implements userService {

    @Autowired
   public userRepository userRepo;
    @Override
    public User insert(User user) {
        user.setLoginData(LocalDate.now().toString());
        user.setLogoutTime(LocalDate.now().toString());
        return userRepo.save(user);
    }

    @Override
    public User getUserByCustomerId(Integer customerId) {
        return userRepo.getUserByCustomerId(customerId);
    }

    @Override
    public boolean deleteCustomerByCustomer(Integer customerId) {
        Integer i = userRepo.deleteUserByCustomerId(customerId);
        return i == 1;
    }
}
