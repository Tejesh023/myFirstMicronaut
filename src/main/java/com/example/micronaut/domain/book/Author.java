package com.example.micronaut.domain.book;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.Setter;

@Serdeable
@Data
@Setter
public class Author {

    private String id;
    private final String firstName;
    private final String lastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
