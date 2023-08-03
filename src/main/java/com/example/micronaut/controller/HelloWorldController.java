package com.example.micronaut.controller;

import com.example.micronaut.service.HelloWorldService;
import com.example.micronaut.service.MyService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
@Controller("/hello")
public class HelloWorldController {

    @Inject
    private MyService service;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return service.helloFromService();
    }

}
