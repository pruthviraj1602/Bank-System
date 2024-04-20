package com.bank.server.services;

import com.bank.server.entiities.User;

import java.awt.desktop.UserSessionEvent;

public interface userService {

    public User insert(User user);
    public User getUserByCustomerId(Integer customerId);
}
