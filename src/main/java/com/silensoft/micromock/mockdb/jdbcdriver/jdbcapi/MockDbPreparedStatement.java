package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.StringValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ClassWithTooManyMethods")
public class MockDbPreparedStatement implements PreparedStatement {
    private static final String PREPARED_STATEMENT = "PreparedStatement";

    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optPreparedStatementMock;
    private ResultSet latestResultSet;

    MockDbPreparedStatement(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newPreparedStatementMock) {
        expectations = newExpectations;
        optPreparedStatementMock = newPreparedStatementMock;
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optPreparedStatementMock
                .flatMap(preparedStatementMock ->
                        expectations.matchAndReturnMockResult(
                            PREPARED_STATEMENT,
                            preparedStatementMock.getName(),
                            "executeQuery",
                            "ResultSet"
                        )
                );

        latestResultSet = new MockDbResultSet(expectations, resultSetMock);
        return latestResultSet;
    }

    @Override
    public int executeUpdate() throws SQLException {
        return optPreparedStatementMock
                .flatMap(preparedStatementMock ->
                        expectations.matchAndReturnIntegerResult(
                            PREPARED_STATEMENT,
                            preparedStatementMock.getName(),
                            "executeUpdate"
                        )
                )
                .orElse(0);
    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType) throws SQLException {
        // noop
    }

    @Override
    public void setBoolean(final int parameterIndex, final boolean x) throws SQLException {
        // noop
    }

    @Override
    public void setByte(final int parameterIndex, final byte x) throws SQLException {
        // noop
    }

    @Override
    public void setShort(final int parameterIndex, final short x) throws SQLException {
        // noop
    }

    @Override
    public void setInt(final int parameterIndex, final int x) throws SQLException {
        // noop
    }

    @Override
    public void setLong(final int parameterIndex, final long x) throws SQLException {
        // noop
    }

    @Override
    public void setFloat(final int parameterIndex, final float x) throws SQLException {
        // noop
    }

    @Override
    public void setDouble(final int parameterIndex, final double x) throws SQLException {
        // noop
    }

    @Override
    public void setBigDecimal(final int parameterIndex, final BigDecimal x) throws SQLException {
        // noop
    }

    @Override
    public void setString(final int parameterIndex, final String x) throws SQLException {
        // noop
    }

    @Override
    public void setBytes(final int parameterIndex, final byte[] x) throws SQLException {
        // noop
    }

    @Override
    public void setDate(final int parameterIndex, final Date x) throws SQLException {
        // noop
    }

    @Override
    public void setTime(final int parameterIndex, final Time x) throws SQLException {
        // noop
    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x) throws SQLException {
        // noop
    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setUnicodeStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void clearParameters() throws SQLException {
        // noop
    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final int targetSqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(int parameterIndex, Object x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute() throws SQLException {
        return optPreparedStatementMock
                .flatMap(preparedStatementMock -> expectations.matchAndReturnBooleanResult(
                        PREPARED_STATEMENT,
                        preparedStatementMock.getName(),
                        "execute")
                )
                .orElse(false);
    }

    @Override
    public void addBatch() throws SQLException {
        // noop
    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setRef(final int parameterIndex, final Ref x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final int parameterIndex, final Blob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final int parameterIndex, final Clob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setArray(final int parameterIndex, final Array x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        final @NotNull Optional<Mock> resultSetMetaDataMock = optPreparedStatementMock.flatMap(preparedStatementMock ->
                expectations.matchAndReturnMockResult(
                        PREPARED_STATEMENT,
                        preparedStatementMock.getName(),
                        "getMetaData",
                        "ResultSetMetaData"
                )
        );

        return new MockDbResultSetMetaData(expectations, resultSetMetaDataMock);
    }

    @Override
    public void setDate(final int parameterIndex, final Date x, final Calendar cal) throws SQLException {
        // noop
    }

    @Override
    public void setTime(final int parameterIndex, final Time x, final Calendar cal) throws SQLException {
        // noop
    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x, final Calendar cal) throws SQLException {
        // noop
    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType, final String typeName) throws SQLException {
        // noop
    }

    @Override
    public void setURL(final int parameterIndex, final URL x) throws SQLException {
        // noop
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setRowId(final int parameterIndex, final RowId x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNString(final int parameterIndex, final String value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNCharacterStream(final int parameterIndex, final Reader value, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final int parameterIndex, final NClob value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final int parameterIndex, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final int parameterIndex, final InputStream inputStream, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final int parameterIndex, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setSQLXML(final int parameterIndex, final SQLXML xmlObject) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final int targetSqlType, final int scaleOrLength) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setAsciiStream(final int parameterIndex, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final int parameterIndex, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCharacterStream(final int parameterIndex, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNCharacterStream(final int parameterIndex, final Reader value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final int parameterIndex, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final int parameterIndex, final InputStream inputStream) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final int parameterIndex, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSet executeQuery(final String sql) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optPreparedStatementMock
                .flatMap(preparedStatementMock ->
                        expectations.matchAndReturnMockResult(
                                PREPARED_STATEMENT,
                                preparedStatementMock.getName(),
                                "executeQuery",
                                List.of(new StringValue(sql)),
                                "ResultSet"
                        )
                );

        latestResultSet = new MockDbResultSet(expectations, resultSetMock);
        return latestResultSet;
    }

    @Override
    public int executeUpdate(final String sql) throws SQLException {
        return optPreparedStatementMock
                .flatMap(preparedStatementMock ->
                        expectations.matchAndReturnIntegerResult(
                                PREPARED_STATEMENT,
                                preparedStatementMock.getName(),
                                "executeUpdate",
                                List.of(new StringValue(sql))
                        )
                )
                .orElse(0);
    }

    @Override
    public void close() throws SQLException {
        // noop
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setMaxFieldSize(final int max) throws SQLException {
        // noop
    }

    @Override
    public int getMaxRows() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setMaxRows(final int max) throws SQLException {
        // noop
    }

    @Override
    public void setEscapeProcessing(final boolean enable) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return 0;
    }

    @Override
    public void setQueryTimeout(final int seconds) throws SQLException {
        // noop
    }

    @Override
    public void cancel() throws SQLException {
        // noop
    }

    @Override
    public @Nullable SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {
        // noop
    }

    @Override
    public void setCursorName(final String name) throws SQLException {
        // noop
    }

    @Override
    public boolean execute(final String sql) throws SQLException {
        return optPreparedStatementMock
                .flatMap(preparedStatementMock ->
                        expectations.matchAndReturnBooleanResult(
                                PREPARED_STATEMENT,
                                preparedStatementMock.getName(),
                                "execute",
                                List.of(new StringValue(sql))
                        )
                )
                .orElse(false);
    }

    @Override
    public @Nullable ResultSet getResultSet() throws SQLException {
        return latestResultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return 0;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return false;
    }

    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        // noop
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return 0;
    }

    @Override
    public void setFetchSize(final int rows) throws SQLException {
        // noop
    }

    @Override
    public int getFetchSize() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        return 0;
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
        return false;
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
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void setPoolable(final boolean poolable) throws SQLException {
        // noop
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        // noop
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }
}
