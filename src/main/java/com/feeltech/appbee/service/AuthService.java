package com.feeltech.appbee.service;

import com.feeltech.appbee.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {



    public void createPassword() {

        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        System.out.println(number);
        String senha = new BCryptPasswordEncoder().encode(String.format("%08d", number));
        System.out.println(senha);


    }





}
