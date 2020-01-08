package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbParseException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

public interface MethodInvocationMatcherParser {

    @NotNull MethodInvocationMatcher parseMethodInvocationMatcher(
            final @NotNull String methodInvocationStatement,
            final @NotNull Mocks mocks
    ) throws MockDbParseException;
}
