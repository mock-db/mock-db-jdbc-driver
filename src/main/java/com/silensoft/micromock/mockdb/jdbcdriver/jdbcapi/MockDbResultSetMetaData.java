package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.IntegerValue;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MockDbResultSetMetaData implements ResultSetMetaData {
    private static final String RESULTSET_METADATA= "ResultSetMetaData";

    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optResultSetMetaDataMock;

    MockDbResultSetMetaData(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newResultSetMetaDataMock) {
        expectations = newExpectations;
        optResultSetMetaDataMock = newResultSetMetaDataMock;
    }

    @Override
    public int getColumnCount() throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnCount"))
                .orElse(0);
    }

    @Override
    public boolean isAutoIncrement(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnCount",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public boolean isCaseSensitive(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isCaseSensitive",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public boolean isSearchable(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isSearchable",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public boolean isCurrency(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isCurrency",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public int isNullable(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isNullable",
                        List.of(new IntegerValue(column))))
                .orElse(0);
    }

    @Override
    public boolean isSigned(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isSigned",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public int getColumnDisplaySize(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnDisplaySize",
                        List.of(new IntegerValue(column))))
                .orElse(0);
    }

    @Override
    public String getColumnLabel(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnLabel",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public String getColumnName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnName",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public String getSchemaName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getSchemaName",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public int getPrecision(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getPrecision",
                        List.of(new IntegerValue(column))))
                .orElse(0);
    }

    @Override
    public int getScale(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getScale",
                        List.of(new IntegerValue(column))))
                .orElse(0);
    }

    @Override
    public String getTableName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getTableName",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public String getCatalogName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getCatalogName",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public int getColumnType(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnType",
                        List.of(new IntegerValue(column))))
                .orElse(0);
    }

    @Override
    public String getColumnTypeName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnTypeName",
                        List.of(new IntegerValue(column))))
                .orElse("");
    }

    @Override
    public boolean isReadOnly(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isReadOnly",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public boolean isWritable(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isWritable",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public boolean isDefinitelyWritable(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "isDefinitelyWritable",
                        List.of(new IntegerValue(column))))
                .orElse(true);
    }

    @Override
    public String getColumnClassName(final int column) throws SQLException {
        return optResultSetMetaDataMock
                .flatMap(resultSetMetaDataMock -> expectations.matchAndReturnStringResult(
                        RESULTSET_METADATA,
                        resultSetMetaDataMock.getName(),
                        "getColumnClassName",
                        List.of(new IntegerValue(column))))
                .orElse("");
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
