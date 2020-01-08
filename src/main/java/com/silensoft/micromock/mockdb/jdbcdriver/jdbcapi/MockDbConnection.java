package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.ExpectationDefinitionsStore;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.ExpectationsFactory;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.ExpectationsType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.ExpectationsTypeStore;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockDefinitionsStore;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MocksFactory;
import com.silensoft.micromock.mockdb.jdbcdriver.value.BooleanValue;
import com.silensoft.micromock.mockdb.jdbcdriver.value.IntegerArrayValue;
import com.silensoft.micromock.mockdb.jdbcdriver.value.IntegerValue;
import com.silensoft.micromock.mockdb.jdbcdriver.value.MockValue;
import com.silensoft.micromock.mockdb.jdbcdriver.value.StringArrayValue;
import com.silensoft.micromock.mockdb.jdbcdriver.value.StringValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Executor;

@SuppressWarnings("ClassWithTooManyMethods")
public class MockDbConnection implements Connection {

    private static final String CONNECTION = "Connection";
    private static final String CREATE_STATEMENT = "createStatement";
    private static final String PREPARE_STATEMENT = "prepareStatement";
    private static final String STATEMENT = "Statement";
    private static final String PREPARED_STATEMENT = "PreparedStatement";
    private static final String PREPARE_CALL = "prepareCall";
    private static final String CALLABLE_STATEMENT = "CallableStatement";
    private static final String SAVEPOINT = "Savepoint";

    @Inject
    private @NotNull MockDefinitionsStore mockDefinitionsStore;

    @Inject
    private @NotNull ExpectationDefinitionsStore expectationDefinitionsStore;

    @Inject
    private @NotNull ExpectationsTypeStore expectationsTypeStore;

    @Inject
    private @NotNull ExpectationsFactory expectationsFactory;

    @Inject
    private @NotNull MocksFactory mocksFactory;

    private final @NotNull Expectations expectations;
    private final @NotNull Mock connectionMock;

    private boolean autoCommit = true;
    private boolean isClosed;
    private boolean isReadOnly;
    private String catalog = "";
    private String schema = "";
    private int transactionIsolationLevel;
    private int holdability;


    public MockDbConnection(final @NotNull String newMockDbHostAndPort) {
        final @NotNull String mockDbHostAndPort = newMockDbHostAndPort;

        final @NotNull List<String> mockDefinitions = mockDefinitionsStore.readMockDefinitions(mockDbHostAndPort);
        final @NotNull Mocks mocks = mocksFactory.createMocks(mockDefinitions);

        final @NotNull List<String> expectationsDefinitions = expectationDefinitionsStore.readExpectationDefinitions(mockDbHostAndPort);
        final @NotNull ExpectationsType expectationsType = expectationsTypeStore.readExpectationsType(mockDbHostAndPort);
        expectations = expectationsFactory.createExpectations(expectationsDefinitions, expectationsType, mocks);

        connectionMock = new MockImpl(CONNECTION, "connection");
    }

    @Override
    public Statement createStatement() throws SQLException {
        final @NotNull Optional<Mock> statementMock
                = expectations.matchAndReturnMockResult(CONNECTION, connectionMock.getName(), CREATE_STATEMENT, STATEMENT);
        return new MockDbStatement(expectations, statementMock);
    }

    @Override
    public PreparedStatement prepareStatement(final String sql) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock =
                expectations.matchAndReturnMockResult(CONNECTION, connectionMock.getName(), PREPARE_STATEMENT, List.of(new StringValue(sql)), PREPARED_STATEMENT);
        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public CallableStatement prepareCall(final String sql) throws SQLException {
        final @NotNull Optional<Mock> callableStatementMock =
                expectations.matchAndReturnMockResult(CONNECTION, connectionMock.getName(), PREPARE_CALL, List.of(new StringValue(sql)), CALLABLE_STATEMENT);
        return new MockDbCallableStatement(expectations, callableStatementMock);
    }

    @Override
    public String nativeSQL(final String sql) throws SQLException {
        final @NotNull Optional<String> nativeSqlResult =
                expectations.matchAndReturnStringResult(CONNECTION, connectionMock.getName(), "nativeSQL", List.of(new StringValue(sql)));
        return nativeSqlResult.orElse(sql);
    }

    @Override
    public void setAutoCommit(final boolean newAutoCommit) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setAutoCommit", List.of(new BooleanValue(newAutoCommit)));
        autoCommit = newAutoCommit;
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        final @NotNull Optional<Boolean> isAutoCommitResult =
                expectations.matchAndReturnBooleanResult(CONNECTION, connectionMock.getName(), "getAutoCommit");
        return isAutoCommitResult.orElse(autoCommit);
    }

    @Override
    public void commit() throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "commit");
    }

    @Override
    public void rollback() throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "rollback");
    }

    @Override
    public void close() throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "close");
        isClosed = true;
    }

    @Override
    public boolean isClosed() throws SQLException {
        final @NotNull Optional<Boolean> isClosedResult =
                expectations.matchAndReturnBooleanResult(CONNECTION, connectionMock.getName(), "isClosed");
        return isClosedResult.orElse(isClosed);
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        final @NotNull Optional<Mock> databaseMetaDataMock =
                expectations.matchAndReturnMockResult(CONNECTION, connectionMock.getName(), "getMetaData", "DatabaseMetaData");
        return new MockDbDatabaseMetaData(expectations, databaseMetaDataMock);
    }

    @Override
    public void setReadOnly(final boolean readOnly) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setReadOnly", List.of(new BooleanValue(readOnly)));
        isReadOnly = true;
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        final @NotNull Optional<Boolean> isReadOnlyResult =
                expectations.matchAndReturnBooleanResult(CONNECTION, connectionMock.getName(), "isReadOnly");
        return isReadOnlyResult.orElse(isReadOnly);
    }

    @Override
    public void setCatalog(final String newCatalog) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setCatalog", List.of(new StringValue(newCatalog)));
        catalog = newCatalog;
    }

    @Override
    public @Nullable String getCatalog() throws SQLException {
        final @NotNull Optional<String> catalogResult =
                expectations.matchAndReturnStringResult(CONNECTION, connectionMock.getName(), "getCatalog");
        return catalogResult.orElse(catalog);
    }

    @Override
    public void setTransactionIsolation(final int level) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setCatalog", List.of(new IntegerValue(level)));
        transactionIsolationLevel = level;
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        final @NotNull Optional<Integer> transactionIsolationLevelResult =
                expectations.matchAndReturnIntegerResult(CONNECTION, connectionMock.getName(), "getTransactionIsolation");
        //noinspection MagicConstant
        return transactionIsolationLevelResult.orElse(transactionIsolationLevel);
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
    public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
        final @NotNull Optional<Mock> statementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                CREATE_STATEMENT,
                List.of(new IntegerValue(resultSetType), new IntegerValue(resultSetConcurrency)),
                STATEMENT
        );

        return new MockDbStatement(expectations, statementMock);
    }

    @Override
    public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_STATEMENT,
                List.of(new StringValue(sql), new IntegerValue(resultSetType), new IntegerValue(resultSetConcurrency)),
                PREPARED_STATEMENT
        );

        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
        final @NotNull Optional<Mock> callableStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_CALL,
                List.of(new StringValue(sql), new IntegerValue(resultSetType), new IntegerValue(resultSetConcurrency)),
                CALLABLE_STATEMENT
        );

        return new MockDbCallableStatement(expectations, callableStatementMock);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTypeMap(final Map<String, Class<?>> map) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setHoldability(final int newHoldability) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setHoldability", List.of(new IntegerValue(newHoldability)));
        holdability = newHoldability;
    }

    @Override
    public int getHoldability() throws SQLException {
        final @NotNull Optional<Integer> holdabilityResult =
                expectations.matchAndReturnIntegerResult(CONNECTION, connectionMock.getName(), "getHoldability");
        return holdabilityResult.orElse(holdability);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        final @NotNull Optional<Mock> savepointMock =
                expectations.matchAndReturnMockResult(CONNECTION, connectionMock.getName(), "setSavepoint", SAVEPOINT);
        return new MockDbSavepoint(expectations, savepointMock);
    }

    @Override
    public Savepoint setSavepoint(final String name) throws SQLException {
        final @NotNull Optional<Mock> savepointMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                "setSavepoint",
                List.of(new StringValue(name)),
                "Savepoint"
        );

        return new MockDbSavepoint(expectations, savepointMock);
    }

    @Override
    public void rollback(final Savepoint savepoint) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "rollback", List.of(new MockValue(SAVEPOINT)));
    }

    @Override
    public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "rollback", List.of(new MockValue(SAVEPOINT)));
    }

    @Override
    public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public PreparedStatement prepareStatement(
            final String sql,
            final int resultSetType,
            final int resultSetConcurrency,
            final int resultSetHoldability
    ) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_STATEMENT,
                List.of(new StringValue(sql), new IntegerValue(resultSetType), new IntegerValue(resultSetConcurrency), new IntegerValue(resultSetHoldability)),
                PREPARED_STATEMENT
        );

        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public CallableStatement prepareCall(
            final String sql,
            final int resultSetType,
            final int resultSetConcurrency,
            final int resultSetHoldability
    ) throws SQLException {
        final @NotNull Optional<Mock> callableStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_CALL,
                List.of(new StringValue(sql), new IntegerValue(resultSetType), new IntegerValue(resultSetConcurrency), new IntegerValue(resultSetHoldability)),
                CALLABLE_STATEMENT
        );

        return new MockDbCallableStatement(expectations, callableStatementMock);
    }

    @Override
    public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_STATEMENT,
                List.of(new StringValue(sql), new IntegerValue(autoGeneratedKeys)),
                PREPARED_STATEMENT
        );

        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_STATEMENT,
                List.of(new StringValue(sql), new IntegerArrayValue(columnIndexes)),
                PREPARED_STATEMENT
        );

        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
        final @NotNull Optional<Mock> preparedStatementMock = expectations.matchAndReturnMockResult(
                CONNECTION,
                connectionMock.getName(),
                PREPARE_STATEMENT,
                List.of(new StringValue(sql), new StringArrayValue(columnNames)),
                PREPARED_STATEMENT
        );

        return new MockDbPreparedStatement(expectations, preparedStatementMock);
    }

    @Override
    public Clob createClob() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob createBlob() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob createNClob() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isValid(final int timeout) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClientInfo(final Properties properties) throws SQLClientInfoException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getClientInfo(final String name) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array createArrayOf(final String typeName, final Object[] elements) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Struct createStruct(final String typeName, final Object[] attributes) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setSchema(final String newSchema) throws SQLException {
        expectations.match(CONNECTION, connectionMock.getName(), "setSchema", List.of(new StringValue(newSchema)));
        schema = newSchema;
    }

    @Override
    public @Nullable String getSchema() throws SQLException {
        final @NotNull Optional<String> schemaResult =
                expectations.matchAndReturnStringResult(CONNECTION, connectionMock.getName(), "getSchema");
        return schemaResult.orElse(schema);
    }

    @Override
    public void abort(final Executor executor) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
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
