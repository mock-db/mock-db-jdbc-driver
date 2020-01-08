package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocation;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationFactory;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class ExpectationImpl implements Expectation {

    @Inject
    private @NotNull MethodInvocationFactory methodInvocationFactory;

    private final @NotNull MethodInvocationMatcher methodInvocationMatcher;
    private final @NotNull Value result;
    // TODO: implement call count support
    private final int expectedCallCount;

    public ExpectationImpl(
            final @NotNull MethodInvocationMatcher newMethodInvocationMatcher,
            final int newExpectedCallCount,
            final @NotNull Value newResult
    ) {
        methodInvocationMatcher = newMethodInvocationMatcher;
        expectedCallCount = newExpectedCallCount;
        result = newResult;
    }

    public @NotNull Value matchAndReturnResult(
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters,
            final @NotNull Optional<String> resultClassName
    ) {

        final MethodInvocation methodInvocation = methodInvocationFactory.createMethodInvocation(instanceName, methodName, methodParameters);

        if (methodInvocationMatcher.matches(methodInvocation) && resultClassName.equals(result.getClassName())) {
            return result;
        }

        throw new MockDbException(MockDbExceptionType.EXPECTATION_MISMATCH);
    }

    @Override
    public @NotNull String getInvocationClassName() {
        return methodInvocationMatcher.getClassName();
    }

    @Override
    public @NotNull String getInvocationMethodName() {
        return methodInvocationMatcher.getMethodName();
    }
}
