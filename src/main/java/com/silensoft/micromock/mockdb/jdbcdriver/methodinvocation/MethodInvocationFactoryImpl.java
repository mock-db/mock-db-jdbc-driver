package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MethodInvocationFactoryImpl implements MethodInvocationFactory {

    @Override
    public @NotNull MethodInvocation createMethodInvocation(
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new MethodInvocationImpl(instanceName, methodName, methodParameters);
    }
}
