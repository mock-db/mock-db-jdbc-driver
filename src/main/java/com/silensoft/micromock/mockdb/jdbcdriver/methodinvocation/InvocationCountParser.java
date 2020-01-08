package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import org.jetbrains.annotations.NotNull;

public interface InvocationCountParser {
    int parseInvocationCount(final @NotNull String invocationCountStatement);
}
