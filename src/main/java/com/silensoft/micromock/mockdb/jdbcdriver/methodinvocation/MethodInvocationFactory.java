package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MethodInvocationFactory {

    @NotNull MethodInvocation createMethodInvocation(
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    );
}
