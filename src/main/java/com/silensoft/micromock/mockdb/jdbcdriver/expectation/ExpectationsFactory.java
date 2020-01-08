package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface ExpectationsFactory {
    @NotNull Expectations createExpectations(
            final @NotNull Collection<String> expectationDefinitions,
            final @NotNull ExpectationsType expectationsType,
            final @NotNull Mocks mocks
    );
}
