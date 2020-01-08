package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

public interface ExpectationParser {
    @NotNull Expectation parseExpectation(final @NotNull String expectationDefinition, final @NotNull Mocks mocks);
}
