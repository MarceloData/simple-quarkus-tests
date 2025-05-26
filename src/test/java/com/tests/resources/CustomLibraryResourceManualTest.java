package com.tests.resources;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.tests.profiles.CustomTestProfile;
import com.tests.repositories.BookRepository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@QuarkusTest
@TestProfile(CustomTestProfile.class)
public class CustomLibraryResourceManualTest {

    public static final String BOOKSTORE_ENDPOINT = "custom/library/book";

    @Inject
    BookRepository bookRepository;

    @Test
    void whenGetBooksGivenNoQuery_thenAllBooksShouldBeReturned() {
        given().contentType(ContentType.JSON).when().get(BOOKSTORE_ENDPOINT).then().statusCode(200)
                .body("size()", is(2)).body("title", hasItems("Foundation", "Dune"));
    }

    @AfterAll
    static void cleanup() {
        try {
            Files.deleteIfExists(Path.of("testdb.mv.db"));
            Files.deleteIfExists(Path.of("testdb.trace.db"));
        } catch (IOException e) {
            System.err.println("Failed to delete H2 DB files: " + e.getMessage());
        }
    }
}
