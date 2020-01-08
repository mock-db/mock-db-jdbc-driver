package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import org.jetbrains.annotations.NotNull;

public interface ClassAndMethod {
    @NotNull String getClassName();
    @NotNull String getMethodName();
}
