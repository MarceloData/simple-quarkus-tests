package com.tests.services;

import java.util.Set;

import com.tests.models.Book;
import com.tests.repositories.BookRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static java.util.stream.Collectors.toSet;

@ApplicationScoped
public class LibraryService {

    @Inject
    BookRepository bookRepository;

    public Set<Book> find(String query) {
        if (query == null) {
            return bookRepository.findAll().stream().collect(toSet());
        }
        return bookRepository.findBy(query).collect(toSet());
    }
}
