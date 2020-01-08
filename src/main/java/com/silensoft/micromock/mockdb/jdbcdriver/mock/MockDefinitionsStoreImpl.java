package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class MockDefinitionsStoreImpl implements MockDefinitionsStore {

    @Override
    public @NotNull List<@NotNull String> readMockDefinitions(final @NotNull String hostAndPort) {
        final @NotNull List<@NotNull String> mockDefinitions = new ArrayList<>(25);

        try (final Connection connection = DriverManager.getConnection("jdbc:h2:~/mock-db", "sa", "")) {

            if (connection == null) {
                throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
            }

            try (final Statement statement = connection.createStatement()) {

                if (statement == null) {
                    throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                }

                try (final ResultSet queryResults = statement.executeQuery("SELECT * FROM mocks")) {
                    if (queryResults == null) {
                        throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                    }

                    while(queryResults.next()) {
                        final String mockDefinition = queryResults.getString(2);
                        if (mockDefinition != null) {
                            mockDefinitions.add(mockDefinition);
                        }
                    }
                }

            }
        } catch (final Exception exception) {
            throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
        }

        return mockDefinitions;
    }
}
