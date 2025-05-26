package com.tests.repositories;

import java.util.stream.Stream;

import com.tests.models.Book;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public Stream<Book> findBy(String query) {
        return find("author like :query or title like :query", with("query", "%" + query + "%")).stream();
    }
}
