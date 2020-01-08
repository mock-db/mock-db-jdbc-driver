package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

public class ExpectationFactoryImpl implements ExpectationFactory {

    @Override
    public @NotNull Expectation createExpectation(
            final @NotNull MethodInvocationMatcher methodInvocationMatcher,
            final int expectedCallCount,
            @NotNull Value result
    ) {
        return new ExpectationImpl(methodInvocationMatcher, expectedCallCount, result);
    }

}
