package com.sgodabee.bankaccountdemo_v1.generator;

import java.util.UUID;

public class Token {

    public static  String generateToken()
    {
        String token = UUID.randomUUID().toString();


        return token;
    }
}
