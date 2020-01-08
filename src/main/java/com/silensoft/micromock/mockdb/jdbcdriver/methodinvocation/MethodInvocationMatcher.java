package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import org.jetbrains.annotations.NotNull;

public interface MethodInvocationMatcher {
    boolean matches(final @NotNull MethodInvocation methodInvocation);
    @NotNull String getClassName();
    @NotNull String getMethodName();
}
