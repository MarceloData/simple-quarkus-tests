package com.tests.config;

import com.tests.models.Book;
import com.tests.repositories.BookRepository;

import io.quarkus.runtime.StartupEvent;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestBookRepository extends BookRepository {

    @Inject
    Book book;

    @Transactional
    public void initData() {
        System.out.println(">>> Populating test books...");
        persist(new Book("Dune", "Frank Herbert"), new Book("Foundation", "Isaac Asimov"));
        System.out.println(">>> Done populating books");
    }

    void onStart(@Observes StartupEvent ev) {
        initData();
    }
}
