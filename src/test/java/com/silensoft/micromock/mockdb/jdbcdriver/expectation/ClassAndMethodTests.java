package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import mockit.Verifications;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("DoubleBraceInitialization")
public class ClassAndMethodTests {

    private static final String CLASS_NAME = "Class";
    private static final String METHOD_NAME = "method";

    @Test
    void testGetClassName() {

        final ClassAndMethod classAndMethod = new ClassAndMethodImpl(CLASS_NAME, METHOD_NAME);

        new Verifications() {{
           assertEquals(classAndMethod.getClassName(), CLASS_NAME);
           assertEquals(classAndMethod.getMethodName(), METHOD_NAME);
        }};
    }
}
