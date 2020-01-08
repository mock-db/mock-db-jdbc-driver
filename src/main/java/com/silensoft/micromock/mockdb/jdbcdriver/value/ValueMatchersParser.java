package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueMatcher;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValueMatchersParser {
    @NotNull List<@NotNull ValueMatcher> parseParameterMatchers(final @NotNull String parameterMatchersStatement, final @NotNull Mocks mocks);
}
