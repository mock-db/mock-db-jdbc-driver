package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MocksFactoryImpl implements MocksFactory {
    @Inject
    private @NotNull MockParser mockParser;

    @Override
    public @NotNull Mocks createMocks(final @NotNull List<@NotNull String> mockDefinitions) {
        final @NotNull List<@NotNull Mock> mocks = mockDefinitions.stream()
                .map(mockParser::parseMock)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return new MocksImpl(mocks);
    }
}
