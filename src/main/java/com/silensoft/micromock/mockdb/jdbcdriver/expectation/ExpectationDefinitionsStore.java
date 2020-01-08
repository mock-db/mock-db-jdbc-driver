package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ExpectationDefinitionsStore {
    @NotNull List<@NotNull String> readExpectationDefinitions(final @NotNull String hostAndPort);
}
