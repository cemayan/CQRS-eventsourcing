package com.ca.usercmdapi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public String hashPassword(String password) {
        var encoder = new BCryptPasswordEncoder(8);
        var hashPassowrd = encoder.encode(password);
        return  hashPassowrd;
    }
}
