package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueMatcher;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MethodInvocationMatcherImpl implements MethodInvocationMatcher {

    private final @NotNull String className;
    private final @NotNull String instanceName;
    private final @NotNull String methodName;
    private final @NotNull List<@NotNull ValueMatcher> methodValueMatchers;

    public MethodInvocationMatcherImpl(
            final @NotNull String newClassName,
            final @NotNull String newInstanceName,
            final @NotNull String newMethodName,
            final @NotNull List<@NotNull ValueMatcher> newMethodValueMatchers
    ) {
        className = newClassName;
        instanceName = newInstanceName;
        methodName = newMethodName;
        methodValueMatchers = new ArrayList<>(newMethodValueMatchers);
    }

    @SuppressWarnings("FeatureEnvy") // POJO access
    @Override
    public boolean matches(final @NotNull MethodInvocation methodInvocation) {
        return instanceName.equals(methodInvocation.getInstanceName()) &&
                methodName.equals(methodInvocation.getMethodName()) &&
                methodParameterMatchersMatch(methodInvocation.getMethodParameters());
    }

    @Override
    public @NotNull String getClassName() {
        return className;
    }

    @Override
    public @NotNull String getMethodName() {
        return methodName;
    }

    private boolean methodParameterMatchersMatch(final @NotNull Iterable<@NotNull Value> methodParameters) {
        boolean allMatches = true;
        final @NotNull Iterator<@NotNull Value> methodParametersIterator = methodParameters.iterator();

        for (final @NotNull ValueMatcher methodValueMatcher : methodValueMatchers) {

            if (methodParametersIterator.hasNext()) {
                final @NotNull Value methodParameter = methodParametersIterator.next();
                allMatches = allMatches && methodValueMatcher.matches(methodParameter);
            } else {
                allMatches = false;
                break;
            }
        }

        return allMatches;
    }
}
