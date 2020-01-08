package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import org.jetbrains.annotations.NotNull;

public enum MockDbExceptionType {
    MOCK_DB_READ_DEFINITIONS_ERROR("Mock DB read definitions error"),
    EXPECTATION_MISMATCH("Expectation mismatch"),
    MISSING_EXPECTATION("Missing expectation"),
    UNSUPPORTED_JDBC_API_OPERATION("Unsupported JDBC API operation");

    private final @NotNull String message;

    MockDbExceptionType(final @NotNull String newMessage) {
        message = newMessage;
    }

    @Override
    public @NotNull String toString() {
        return message;
    }
}
