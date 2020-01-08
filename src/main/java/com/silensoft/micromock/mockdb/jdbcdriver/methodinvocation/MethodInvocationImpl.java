package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodInvocationImpl implements MethodInvocation {
    private final @NotNull String instanceName;
    private final @NotNull String methodName;
    private final @NotNull List<@NotNull Value> methodParameters;

    public MethodInvocationImpl(
            final @NotNull String newInstanceName,
            final @NotNull String newMethodName,
            final @NotNull List<@NotNull Value> newMethodParameters
    ) {
        instanceName = newInstanceName;
        methodName = newMethodName;
        methodParameters = new ArrayList<>(newMethodParameters);
    }

    @Override
    public @NotNull String getInstanceName() {
        return instanceName;
    }

    @Override
    public @NotNull String getMethodName() {
        return methodName;
    }

    @Override
    public @NotNull List<@NotNull Value> getMethodParameters() {
        return Collections.unmodifiableList(methodParameters);
    }
}