package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.StringValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ClassWithTooManyMethods")
public class MockDbStatement implements Statement {

    private static final String STATEMENT = "Statement";

    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optStatementMock;
    private ResultSet latestResultSet;

    MockDbStatement(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newStatementMock) {
        expectations = newExpectations;
        optStatementMock = newStatementMock;
    }

    @Override
    public ResultSet executeQuery(final String sql) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optStatementMock.flatMap(statementMock ->
                expectations.matchAndReturnMockResult(
                        STATEMENT,
                        statementMock.getName(),
                        "executeQuery",
                        List.of(new StringValue(sql)),
                        "ResultSet")
        );

        latestResultSet = new MockDbResultSet(expectations, resultSetMock);
        return latestResultSet;
    }

    @Override
    public int executeUpdate(final String sql) throws SQLException {
        return optStatementMock
                .flatMap(statementMock -> expectations.matchAndReturnIntegerResult(
                        STATEMENT,
                        statementMock.getName(),
                        "executeUpdate",
                        List.of(new StringValue(sql)))).orElse(0);
    }

    @Override
    public void close() throws SQLException {
        optStatementMock.ifPresent(statementMock -> expectations.match(STATEMENT, statementMock.getName(), "close"));
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setMaxFieldSize(final int max) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setMaxRows(final int max) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setEscapeProcessing(final boolean enable) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setQueryTimeout(final int seconds) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void cancel() throws SQLException {
        optStatementMock.ifPresent(statementMock -> expectations.match(STATEMENT, statementMock.getName(), "cancel"));
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCursorName(final String name) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute(final String sql) throws SQLException {
        return optStatementMock
                .flatMap(statementMock -> expectations.matchAndReturnBooleanResult(
                        STATEMENT,
                        statementMock.getName(),
                        "execute",
                        List.of(new StringValue(sql)))).orElse(false);
    }

    @Override
    public @Nullable ResultSet getResultSet() throws SQLException {
        return latestResultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setFetchSize(final int rows) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getResultSetType() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void addBatch(final String sql) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void clearBatch() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int[] executeBatch() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Connection getConnection() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean getMoreResults(final int current) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int executeUpdate(final String sql, final int autoGeneratedKeys) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int executeUpdate(final String sql, final int[] columnIndexes) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int executeUpdate(final String sql, final String[] columnNames) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute(final String sql, final int autoGeneratedKeys) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute(final String sql, final int[] columnIndexes) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute(final String sql, final String[] columnNames) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setPoolable(final boolean poolable) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isPoolable() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }
}
