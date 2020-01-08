package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockParser;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MocksFactory {
    @NotNull Mocks createMocks(final @NotNull List<@NotNull String> mockDefinitions);
}
