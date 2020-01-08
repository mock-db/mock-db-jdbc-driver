package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import com.silensoft.micromock.mockdb.jdbcdriver.failurereporter.FailureReporterImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.Verifications;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("DoubleBraceInitialization")
public class MockDbTableResultSetExceptionTests {

    private static final String CHILD_EXCEPTION_MESSAGE = "Message";

    private final @NotNull Exception childExceptionMock = new Exception(CHILD_EXCEPTION_MESSAGE);

    @Test
    void testExceptionConstruction() {
        new MockUp<FailureReporterImpl>() {
            @Mock
            void reportFailure(final @NotNull String message) throws IOException {
            }
        };

        final Exception parentException = new MockDbTableResultSetException(childExceptionMock);

        new Verifications() {{
            assertEquals(parentException.getMessage(), CHILD_EXCEPTION_MESSAGE);
        }};
    }
}
