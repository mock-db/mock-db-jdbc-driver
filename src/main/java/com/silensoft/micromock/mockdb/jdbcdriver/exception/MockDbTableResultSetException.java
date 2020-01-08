package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import org.jetbrains.annotations.NotNull;

public class MockDbTableResultSetException extends ReportableException {
    public MockDbTableResultSetException(final @NotNull Exception exception) {
        super(exception.getMessage() != null ? exception.getMessage() : "No message");
    }
}
