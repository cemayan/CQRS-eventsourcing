package com.ca.usercmdapi.security;

public interface PasswordEncoder {

    String hashPassword(String password);
}
