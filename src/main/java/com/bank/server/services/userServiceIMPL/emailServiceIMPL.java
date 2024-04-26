package com.bank.server.services.userServiceIMPL;

import com.bank.server.services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;
import java.util.Random;

@Service
public class emailServiceIMPL implements emailService {

    final Cookie ck=new Cookie();
    @Autowired
    JavaMailSender mailSender;

    final static String FROM="pruthviraj7191@gmail.com";


    @Override
    public void sendMail(String to, String subject) {
        Random r= new Random();
        int otp=r.nextInt(9000)+1000;
        String ot=otp+"";
        ck.setName(ot);
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("OTP :  "+ot);
        simpleMailMessage.setFrom(FROM);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public boolean verifyOtp(String otp) {
        String myOtp=ck.getName();
        System.out.println("1 OTP "+myOtp);
        System.out.println("2 OTP "+otp);

        boolean b= Objects.equals(otp,myOtp);
        if (b){
            ck.setName("");
            Duration duration=Duration.ofSeconds(30);
            ck.setMaxAge(duration);
            System.out.println("duration otp "+myOtp);

            return true;
        }
        return false;
    }
}
