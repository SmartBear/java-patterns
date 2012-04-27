package com.smartbear.patterns.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComplexImmutableTest {

    private final ComplexImmutableBuilder builder = new ComplexImmutableBuilder();

    @Test
     public void testComplexImmutable(){

        ComplexImmutable complexImmutableObject = builder.withConnectionTimeout(1000).
                usingStrictMode(true).named("The name").inNameSpace("The namespace").
                withContext("The context").initializedTo(111).build();

        assertEquals("Invalid class created!",ComplexImmutableObject.class,complexImmutableObject.getClass());
        assertTrue("Invalid object created!",complexImmutableObject.performAction().startsWith("Hi from ComplexImmutableObject"));
    }

    @Test
    public void testExtraComplexImmutable(){

        ComplexImmutable complexImmutableObject = builder.withConnectionTimeout(1000).
                usingStrictMode(true).named("The name").inNameSpace("The namespace").
                withContext("The context").withAspect("The aspect").initializedTo(1212).build();

        assertEquals("Invalid class created!",ExtraComplexImmutableObject.class,complexImmutableObject.getClass());
        assertTrue("Invalid object created!",complexImmutableObject.performAction().startsWith("Hi from ExtraComplexImmutableObject"));
    }
}
