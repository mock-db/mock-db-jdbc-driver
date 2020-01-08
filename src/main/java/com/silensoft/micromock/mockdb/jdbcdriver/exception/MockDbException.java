package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import org.jetbrains.annotations.NotNull;

public class MockDbException extends ReportableException {

    public MockDbException(final @NotNull MockDbExceptionType subType) {
        super(subType.toString());
    }
}
