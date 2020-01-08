package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

public interface ExpectationFactory {

    @NotNull Expectation createExpectation(
            final @NotNull MethodInvocationMatcher newMethodInvocationMatcher,
            final int newExpectedCallCount,
            final @NotNull Value newResult
    );
}
