package com.tests.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.tests.interfaces.TransactionalTestContext;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TransactionalTestContext
public class BookRepositoryIntegrationTest {
    @Inject
    BookRepository bookRepository;

    @Test
    void givenBookInRepository_whenFindByAuthor_thenShouldReturnBookFromRepository() {
        assertTrue(bookRepository.findBy("Herbert").findAny().isPresent());
    }
}
