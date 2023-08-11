package com.example.micronaut.domain;

import lombok.Data;
@Data
public class BookRequest {
    private String name;
    private int pageCount;
    private AuthorRequest author;
}
