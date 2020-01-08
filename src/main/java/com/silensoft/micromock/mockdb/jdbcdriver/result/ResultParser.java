package com.silensoft.micromock.mockdb.jdbcdriver.result;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

public interface ResultParser {
    @NotNull Value parseResult(final @NotNull String resultStatement, final @NotNull Mocks mocks);
}
