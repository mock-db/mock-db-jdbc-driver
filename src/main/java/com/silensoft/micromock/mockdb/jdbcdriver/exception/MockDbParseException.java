package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import org.jetbrains.annotations.NotNull;

public class MockDbParseException extends ReportableException {

    public MockDbParseException(final @NotNull String message) {
        super(message);
    }
}
