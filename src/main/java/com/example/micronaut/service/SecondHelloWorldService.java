package com.example.micronaut.service;

import jakarta.inject.Singleton;

@Singleton
public class SecondHelloWorldService implements MyService{

    @Override
    public String helloFromService() {
        return "Hello World From Second Service!";
    }
}
