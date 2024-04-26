package com.bank.server.services;

import com.bank.server.entiities.Account;
import com.bank.server.entiities.User;

import java.awt.desktop.UserSessionEvent;

public interface userService {

    public User insert(User user);
    public User getUserByCustomerId(Integer customerId);
    public boolean deleteCustomerByCustomer(Integer customerId);

    public User getUserByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword);

    public User setEnable(Integer customerId);

    public User updateUser(User user);


}
