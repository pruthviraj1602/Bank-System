package com.bank.server.services;

public interface emailService {
    public void sendMail(String to,String subject);
    public boolean verifyOtp(String otp);
}
