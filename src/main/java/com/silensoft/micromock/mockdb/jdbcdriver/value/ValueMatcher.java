package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

public interface ValueMatcher {
    boolean matches(@NotNull Value otherValue);
}
