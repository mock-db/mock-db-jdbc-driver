package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface MockParser {
    @NotNull Optional<Mock> parseMock(final @NotNull String mockDefintion);
}
