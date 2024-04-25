package com.bank.server.controllers;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;
import com.bank.server.security.Authentication;
import com.bank.server.services.userServiceIMPL.accountServiceIMPL;
import com.bank.server.services.userServiceIMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    public userServiceIMPL userSerImpl;
    @Autowired
    public accountServiceIMPL accountIMPL;
    @Autowired
    public Authentication authentication;

   @PostMapping("/insert")
    public User insert(@RequestBody User user){
        return userSerImpl.insert(user);

    }
    @PostMapping("/loginUser")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        String customerEmail = user.getCustomerEmail();
        String customerPassword = user.getCustomerPassword();
        User loginUser = userSerImpl.getUserByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(loginUser);
    }

    @GetMapping("/getUser/{customerId}")
   public User getUserByCustomerId(@PathVariable Integer customerId){
       return userSerImpl.getUserByCustomerId(customerId);
   }

   @PostMapping("/getCustomer")
   public User getUserByCustomerEmailAndCustomerPassword( @RequestBody User user){
       String customerEmail = user.getCustomerEmail();
       String customerPassword = user.getCustomerPassword();
       return userSerImpl.getUserByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
   }

   @DeleteMapping("/deleteUser/{customerId}")
   public boolean deleteCustomerById(@PathVariable Integer customerId){
       return userSerImpl.deleteCustomerByCustomer(customerId);
   }

   @PostMapping("/getAccount/{accountNumber}")
   public Account getAccountByAccountNumber(@PathVariable String accountNumber){
       return accountIMPL.getAccountByAccountNumber(accountNumber);
   }

   @PostMapping("/updateUser")
   public User updateUser(@RequestBody User user){
       boolean b = authentication.authorized();
       if(b) {
           return userSerImpl.updateUser(user);
       }
       return null;
   }



}
