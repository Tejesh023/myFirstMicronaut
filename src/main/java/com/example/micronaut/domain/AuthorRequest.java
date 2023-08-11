package com.example.micronaut.domain;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
@Data
@Serdeable
public class AuthorRequest {

    private String firstName;
    private String lastName;
}
