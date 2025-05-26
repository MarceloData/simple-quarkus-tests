package com.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tests.models.Book;
import com.tests.repositories.BookRepository;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class LibraryServiceQuarkusMockUnitSimplifiedTest {

    @Inject
    LibraryService libraryService;

    @InjectMock
    BookRepository bookRepository;

    @BeforeEach
    void setup() {
        when(bookRepository.findBy("Frank Herbert")).thenReturn(
                Stream.of(new Book("Dune", "Frank Herbert"), new Book("Children of Dune", "Frank Herbert")));
    }

    @Test
    void whenFindByAuthor_thenBooksShouldBeFound() {
        assertEquals(2, libraryService.find("Frank Herbert").size());
    }
}
