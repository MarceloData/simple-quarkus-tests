package com.tests.nativetests;

import com.tests.resources.LibraryHttpEndpointIntegrationTest;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@QuarkusTestResource(value = H2DatabaseTestResource.class, restrictToAnnotatedClass = true)
public class NativeLibraryResourceIT extends LibraryHttpEndpointIntegrationTest {

}
