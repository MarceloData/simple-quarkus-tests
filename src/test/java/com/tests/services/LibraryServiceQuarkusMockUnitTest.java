package com.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tests.config.TestBookRepository;
import com.tests.models.Book;
import com.tests.repositories.BookRepository;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class LibraryServiceQuarkusMockUnitTest {

    @Inject
    LibraryService libraryService;

    @BeforeEach
    void setup() {
        BookRepository mock = Mockito.mock(TestBookRepository.class);
        Mockito.when(mock.findBy("Asimov")).thenReturn(Arrays
                .stream(new Book[] { new Book("Foundation", "Isac Asimov"), new Book("I Robot", "Isaac Asimov") }));
        QuarkusMock.installMockForType(mock, BookRepository.class);
    }

    @Test
    void whenFindByAuthor_thenBooksShouldBeFound() {
        assertEquals(2, libraryService.find("Asimov").size());
    }
}
