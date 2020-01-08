package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MethodInvocation {
    @NotNull String getInstanceName();
    @NotNull String getMethodName();
    @NotNull List<@NotNull Value> getMethodParameters();
}
