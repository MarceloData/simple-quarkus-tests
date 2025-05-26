package com.tests.resources;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.tests.services.LibraryService;
import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;

@QuarkusTest
public class LibraryResourceInjectSpyIntegrationTest {

    @InjectSpy
    LibraryService libraryService;

    @Test
    void whenGetBooksByAuthor_thenBookShouldBeFound() {
        given().contentType(ContentType.JSON).param("query", "Asimov").when().get("/library/book").then()
                .statusCode(200);

        verify(libraryService).find("Asimov");
    }
}
