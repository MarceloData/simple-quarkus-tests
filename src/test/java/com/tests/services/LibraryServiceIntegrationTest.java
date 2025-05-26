package com.tests.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class LibraryServiceIntegrationTest {

    @Inject
    LibraryService libraryService;

    @Test
    void whenFindByAuthor_thenBookShouldBeFound() {
        assertFalse(libraryService.find("Frank Herbert").isEmpty());
    }
}
