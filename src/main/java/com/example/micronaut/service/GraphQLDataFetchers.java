package com.example.micronaut.service;

import graphql.schema.DataFetcher;
import com.example.micronaut.domain.book.Book;
import com.example.micronaut.domain.book.Author;
import com.example.micronaut.repository.DbRepository;

import jakarta.inject.Singleton;

@Singleton
public class GraphQLDataFetchers {

    private final DbRepository dbRepository;

    public GraphQLDataFetchers(DbRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return dbRepository.findAllBooks()
                    .stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            Author authorBook = book.getAuthor();
            return dbRepository.findAllAuthors()
                    .stream()
                    .filter(author -> author.getId().equals(authorBook.getId()))
                    .findFirst()
                    .orElse(null);
        };
    }
}