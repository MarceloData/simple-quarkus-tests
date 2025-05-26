package com.tests.resources;

import java.io.IOException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.restassured.http.ContentType;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

import org.apache.commons.io.IOUtils;
import static java.nio.charset.Charset.defaultCharset;

@QuarkusTest
@TestHTTPEndpoint(LibraryResource.class)
public class LibraryResourceIntegrationTest {

    @TestHTTPResource("/book")
    URL libraryEndpoint;

    @Test
    void whenGetBooksByTitle_thenBookShouldBeFound_withPath() {

        given().contentType(ContentType.JSON).param("query", "Dune").when().get("/book").then().statusCode(200)
                .body("size()", is(1)).body("title", hasItem("Dune")).body("author", hasItem("Frank Herbert"));
    }

    @Test
    void whenGetBooksByTitle_thenBookShouldBeFound_withUrlAnnotation() {

        given().param("query", "Dune").when().get(libraryEndpoint).then().statusCode(200);
    }

    @Test
    void whenGetBooks_thenBooksShouldBeFound() throws IOException {
        assertTrue(IOUtils.toString(libraryEndpoint.openStream(), defaultCharset()).contains("Asimov"));
    }

    @Test
    void whenGetBooks_thenShouldReturnSuccessfully() {
        given().contentType(ContentType.JSON).when().get("book").then().statusCode(200);
    }
}
