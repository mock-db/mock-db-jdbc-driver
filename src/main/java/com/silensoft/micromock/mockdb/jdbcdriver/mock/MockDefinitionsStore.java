package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

public interface MockDefinitionsStore {
    @NotNull List<@NotNull String> readMockDefinitions(final @NotNull String hostAndPort);
}
