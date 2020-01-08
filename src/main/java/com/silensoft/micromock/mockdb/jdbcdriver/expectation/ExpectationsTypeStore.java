package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import org.jetbrains.annotations.NotNull;

public interface ExpectationsTypeStore {
    @NotNull ExpectationsType readExpectationsType(final @NotNull String mockDbHostAndPort);
}
