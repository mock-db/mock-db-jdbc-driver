package com.silensoft.micromock.mockdb.jdbcdriver.value;

import org.jetbrains.annotations.NotNull;

public interface ValueParser {
    @NotNull Value parseReturnValue(final @NotNull String returnValue);
    @NotNull Value parseParameterValue(final @NotNull String parameterValue);
}
