package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpectationDefinitionsStoreImpl implements ExpectationDefinitionsStore {

    public static final String READ_EXPECTATIONS = "SELECT * FROM expectations";

    @Override
    public @NotNull List<@NotNull String> readExpectationDefinitions(final @NotNull String hostAndPort) {

        final @NotNull List<@NotNull String> expectationDefinitions = new ArrayList<>(25);

        try (final Connection connection = DriverManager.getConnection("jdbc:h2:~/testdb", "sa", "")) {

            if (connection == null) {
                throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
            }

            try (final Statement statement = connection.createStatement()) {

                if (statement == null) {
                    throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                }

                try (final ResultSet queryResults = statement.executeQuery(READ_EXPECTATIONS)) {

                    if (queryResults == null) {
                        throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                    }

                    while(queryResults.next()) {
                        final String expectationDefinition = queryResults.getString(2);
                        if (expectationDefinition != null) {
                            expectationDefinitions.add(expectationDefinition);
                        }
                    }
                }
            }
        } catch (final Exception exception) {
            throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
        }

        return expectationDefinitions;
    }
}
