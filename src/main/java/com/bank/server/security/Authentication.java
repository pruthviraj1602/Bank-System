package com.bank.server.security;

import com.bank.server.entiities.User;
import com.bank.server.repositories.userRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Authentication {

    @Autowired
    public userRepository userServ;

    private String email;
    private String password;

    public boolean authorized(){
        boolean b=false;
        String email1 = getEmail();
        String password1 = getPassword();
        User userEmailAndPassword = userServ.getUserByCustomerEmailAndCustomerPassword(email1, password1);
        if(userEmailAndPassword!=null){
            b=true;
        }
       return b;
    }
}
