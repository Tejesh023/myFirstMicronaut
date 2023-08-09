package com.example.micronaut.service;

import com.example.micronaut.domain.book.Author;
import com.example.micronaut.domain.book.Book;
import com.example.micronaut.repository.BookRepository;
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

//    private static final List<Book> books = Arrays.asList(
//            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, new Author("author-1", "Joanne", "Rowling")),
//            new Book("book-2", "Moby Dick", 635, new Author("author-2", "Herman", "Melville")),
//            new Book("book-3", "Interview with the vampire", 371, new Author("author-3", "Anne", "Rice"))
//    );

//    public void saveBooks() {
//        bookRepository.saveAll(books);
//    }

    @Override
    @Transactional
    public Book get(DataFetchingEnvironment env) {
//        String id = env.getArgument("id");
        String name = env.getArgument("name");
//        int pageCount = env.getArgument("pageCount");
        String firstName = env.getArgument("firstName");
        String lastName = env.getArgument("lastName");
        UUID uuid = UUID.randomUUID();
        Author author = new Author(uuid.toString(), firstName, lastName);
        Book book = new Book(uuid.toString(), name, 250, author);
        return bookRepository.save(book);
    }
}