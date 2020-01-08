package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import org.jetbrains.annotations.NotNull;

public class ClassAndMethodImpl implements ClassAndMethod {

    private final @NotNull String className;
    private final @NotNull String methodName;

    public ClassAndMethodImpl(final @NotNull String newClassName, final @NotNull String newMethodName) {
        className = newClassName;
        methodName = newMethodName;
    }

    @Override
    public @NotNull String getClassName() {
        return className;
    }

    @Override
    public @NotNull String getMethodName() {
        return methodName;
    }
}
