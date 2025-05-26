package com.tests.resources;

import java.util.Set;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import com.tests.services.LibraryService;

@Path("/library")
public class LibraryResource {

    @Inject
    LibraryService libraryService;

    @SuppressWarnings("rawtypes")
    @GET
    @Path("/book")
    public Set findBooks(@QueryParam("query") String query) {
        return libraryService.find(query);
    }
}
