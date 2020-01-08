package com.silensoft.micromock.mockdb.jdbcdriver.failurereporter;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MethodParameterOfConcreteClass")
public interface FailureReporter {
    void reportFailure(final @NotNull String failureMessage);
}
