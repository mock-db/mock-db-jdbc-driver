package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface Mocks {
    @NotNull Optional<Mock> findMockByName(final @NotNull String name);
}
