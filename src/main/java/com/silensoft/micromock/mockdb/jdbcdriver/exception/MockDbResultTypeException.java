package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import org.jetbrains.annotations.NotNull;

public class MockDbResultTypeException extends ReportableException {

    public MockDbResultTypeException(final @NotNull String message) {
        super(message);
    }
}
