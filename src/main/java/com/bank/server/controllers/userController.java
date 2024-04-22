package com.bank.server.controllers;

import com.bank.server.entiities.User;
import com.bank.server.services.userServiceIMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    public userServiceIMPL userSerImpl;
   @PostMapping("/insert")
    public User insert(@RequestBody User user){
        return userSerImpl.insert(user);

    }

    @GetMapping("/getUser/{customerId}")
   public User getUserByCustomerId(@PathVariable Integer customerId){
       return userSerImpl.getUserByCustomerId(customerId);
   }

   @DeleteMapping("/deleteUser/{customerId}")
   public boolean deleteCustomerById(@PathVariable Integer customerId){
       return userSerImpl.deleteCustomerByCustomer(customerId);
   }
}
