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

public class ExpectationsTypeStoreImpl implements ExpectationsTypeStore {

    @Override
    public @NotNull ExpectationsType readExpectationsType(final @NotNull String mockDbHostAndPort) {
        @NotNull ExpectationsType expectationsType = ExpectationsType.ANY_ORDER;

        try (final Connection connection = DriverManager.getConnection("jdbc:h2:~/mock-db", "sa", "")) {

            if (connection == null) {
                throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
            }

            try (final Statement statement = connection.createStatement()) {

                if (statement == null) {
                    throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                }

                try (final ResultSet queryResults = statement.executeQuery("SELECT * FROM expectationstype")) {
                    if (queryResults == null) {
                        throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
                    }

                    while(queryResults.next()) {
                        final String expectationsTypeStr = queryResults.getString(1);
                        if (expectationsTypeStr != null) {
                            expectationsType = ExpectationsType.valueOf(expectationsTypeStr);
                        }
                    }
                }

            }
        } catch (final Exception exception) {
            throw new MockDbException(MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR);
        }

        return expectationsType;
    }
}
