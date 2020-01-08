package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface Expectation {
    @NotNull Value matchAndReturnResult(
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters,
            @NotNull Optional<String> resultClassName
    );

    @NotNull String getInvocationClassName();
    @NotNull String getInvocationMethodName();
}
