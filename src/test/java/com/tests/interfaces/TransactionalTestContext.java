package com.tests.interfaces;

import jakarta.transaction.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.enterprise.inject.Stereotype;

@Stereotype
@Transactional
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionalTestContext {

}
