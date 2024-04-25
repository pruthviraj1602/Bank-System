package com.bank.server.services.userServiceIMPL;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.repositories.userRepository;
import com.bank.server.security.Authentication;
import com.bank.server.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class userServiceIMPL implements userService {

    @Autowired
   public userRepository userRepo;
   @Autowired
    public Authentication authentication;
    @Override
    public User insert(User user) {
        user.setLoginData(LocalDate.now().toString());
        user.setLogoutTime(LocalDate.now().toString());
        user.setEnable(false);
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

    @Override
    public User getUserByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword) {
        User cust = userRepo.getUserByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
        if (cust!=null){
            String customerEmail1 = cust.getCustomerEmail();
            String customerPassword1 = cust.getCustomerPassword();
            authentication.setEmail(customerEmail1);
            authentication.setPassword(customerPassword1);
        }
       return cust;
    }

    @Override
    public User setEnable(Integer customerId) {
        User id = userRepo.getUserByCustomerId(customerId);
         if(id!=null){
             id.setEnable(true);
             User save = userRepo.save(id);
             return userRepo.save(save);
         }
        return null;
    }

    @Override
    public User updateUser(User user) {
        Integer customerId = user.getCustomerId();
        User userByCustomerId = userRepo.getUserByCustomerId(customerId);
        userByCustomerId.setCustomerName(user.getCustomerName());
        userByCustomerId.setCustomerContact(user.getCustomerContact());
        userByCustomerId.setCustomerEmail(user.getCustomerEmail());
        userByCustomerId.setCustomerPassword(user.getCustomerPassword());
        return userRepo.save(userByCustomerId);
    }
}
