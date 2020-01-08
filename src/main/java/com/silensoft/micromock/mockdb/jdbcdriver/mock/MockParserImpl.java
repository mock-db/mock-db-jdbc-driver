package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockParser;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class MockParserImpl implements MockParser {

    @Override
    public @NotNull Optional<Mock> parseMock(final @NotNull String mockDefinition) {
        final String[] mockDefinitionParts = mockDefinition.split(" ");
        if (mockDefinitionParts.length != 2) {
            return Optional.empty();
        }

        final String mockClassName = mockDefinitionParts[0].trim();
        String mockName = mockDefinitionParts[1].trim();

        if (mockName.endsWith(";")) {
            mockName = mockName.substring(0, mockName.length() - 1);
        } else {
            return Optional.empty();
        }

        return Optional.of(new MockImpl(mockClassName, mockName));
    }
}
