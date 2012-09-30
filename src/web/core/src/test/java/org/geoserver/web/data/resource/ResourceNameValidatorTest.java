package org.geoserver.web.data.resource;


import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.geoserver.web.StringValidatable;
import org.geoserver.web.data.resource.BasicResourceConfig.ResourceNameValidator;
import org.junit.Test;

public class ResourceNameValidatorTest {

    @Test
    public void testValidUnderscoreMiddle() {
        StringValidatable validatable = new StringValidatable("abc_def");
        new ResourceNameValidator().validate(validatable);
        assertTrue(validatable.isValid());
    }
    
    @Test
    public void testValidUnderscoreStart() {
        StringValidatable validatable = new StringValidatable("_def");
        new ResourceNameValidator().validate(validatable);
        assertTrue(validatable.isValid());
    }
    
    @Test
    public void testValidPoint() {
        StringValidatable validatable = new StringValidatable("abc.def");
        new ResourceNameValidator().validate(validatable);
        assertTrue(validatable.isValid());
    }
    
    @Test
    public void testEmpty() {
        StringValidatable validatable = new StringValidatable("");
        new ResourceNameValidator().validate(validatable);
        assertFalse(validatable.isValid());
    }
    
    @Test
    public void testSpace() {
        StringValidatable validatable = new StringValidatable("abc def");
        new ResourceNameValidator().validate(validatable);
        assertFalse(validatable.isValid());
    }
}
