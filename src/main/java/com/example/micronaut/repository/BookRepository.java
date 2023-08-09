package com.example.micronaut.repository;

import com.example.micronaut.domain.book.Book;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository(databaseName = "dev-sos-001")
public interface BookRepository extends CrudRepository<Book, String> {
    Book find(String id);
}
