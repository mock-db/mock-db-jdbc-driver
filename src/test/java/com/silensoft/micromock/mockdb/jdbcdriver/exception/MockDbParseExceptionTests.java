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
public class MockDbParseExceptionTests {

    private static final String MESSAGE = "Message";

    @Test
    void testExceptionConstruction() {
        new MockUp<FailureReporterImpl>() {
            @Mock
            void reportFailure(final @NotNull String message) throws IOException {
            }
        };

        final Exception exception = new MockDbParseException(MESSAGE);

        new Verifications() {{
            assertEquals(exception.getMessage(), MESSAGE);
        }};
    }
}
