package com.tests.profiles;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.tests.config.TestBookRepository;

import io.quarkus.test.junit.QuarkusTestProfile;

public class CustomTestProfile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.resteasy.path", "/custom");
    }

    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Collections.singleton(TestBookRepository.class);
    }

    @Override
    public String getConfigProfile() {
        return "custom-profile";
    }
}
