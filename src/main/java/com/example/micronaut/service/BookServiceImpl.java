package com.example.micronaut.service;

import com.example.micronaut.domain.BookRequest;
import com.example.micronaut.domain.book.Author;
import com.example.micronaut.domain.book.Book;
import com.example.micronaut.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Singleton
public class BookServiceImpl implements DataFetcher<Book> {


    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book get(DataFetchingEnvironment env) {
        ObjectMapper mapper = new ObjectMapper();
        BookRequest request = mapper.convertValue(env.getArgument("book"), BookRequest.class);
        UUID uuid = UUID.randomUUID();
        Author author = new Author(uuid.toString(), request.getAuthor().getFirstName(), request.getAuthor().getLastName());
        Book book = new Book(uuid.toString(), request.getName(), request.getPageCount(), author);
        return bookRepository.save(book);
    }

    public Book getBookById(DataFetchingEnvironment env) {
        String id = env.getArgument("id");
        return bookRepository.find(id);
    }

}