package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbTableResultSetException;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.tableresultset.TableResultSet;
import com.silensoft.micromock.mockdb.jdbcdriver.value.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ClassWithTooManyMethods")
public class MockDbResultSet implements ResultSet {
    private final static String RESULT_SET = "ResultSet";
    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optResultSetMock;

    private final @NotNull Optional<TableResultSet> optTableResultSet;

    public MockDbResultSet(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newResultSetMock) {
        expectations = newExpectations;
        optResultSetMock = newResultSetMock;
        optTableResultSet = optResultSetMock.flatMap(Mock::getTableResultSet);
    }

    @Override
    public boolean next() throws SQLException {
        return false;
    }

    @Override
    public void close() throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(
                    TableResultSet::close,
                    () -> optResultSetMock.ifPresent(resultSetMock -> expectations.match(RESULT_SET, resultSetMock.getName(), "close"))
            );
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean wasNull() throws SQLException {
        return false;
    }

    @Override
    public @Nullable String getString(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                .map(tableResultSet -> tableResultSet.getString(columnIndex))
                .orElse(optResultSetMock.flatMap(resultSetMock ->
                        expectations.matchAndReturnStringResult(
                                RESULT_SET,
                                resultSetMock.getName(),
                                "getString",
                                List.of(new IntegerValue(columnIndex)))
                ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean getBoolean(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBoolean(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBoolean",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public byte getByte(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getByte(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnByteResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBoolean",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse((byte)0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public short getShort(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getShort(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnShortResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getShort",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse((short) 0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getInt(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getInt(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getInt",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public long getLong(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getLong(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnLongResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getLong",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(0L));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public float getFloat(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getFloat(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnFloatResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getFloat",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(0.0f));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public double getDouble(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getDouble(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnDoubleResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getDouble",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(0.0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final int columnIndex, final int scale) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBigDecimal(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBigDecimalResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBigDecimal",
                                    List.of(new IntegerValue(columnIndex), new IntegerValue(scale)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable byte[] getBytes(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBytes(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnByteArrayResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBytes",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Date getDate(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getDate(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnDateResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getDate",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Time getTime(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getTime(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnTimeResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getTime",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Timestamp getTimestamp(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getTimestamp(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnTimestampResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getTimestamp",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public InputStream getUnicodeStream(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getBinaryStream(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public @Nullable String getString(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getString(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnStringResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getString",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean getBoolean(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBoolean(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBoolean",
                                    List.of(new StringValue(columnName)))
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public byte getByte(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getByte(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnByteResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getByte",
                                    List.of(new StringValue(columnName)))
                    ).orElse((byte) 0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public short getShort(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getShort(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnShortResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getShort",
                                    List.of(new StringValue(columnName)))
                    ).orElse((short) 0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getInt(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getInt(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getInt",
                                    List.of(new StringValue(columnName)))
                    ).orElse(0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public long getLong(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getLong(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnLongResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getLong",
                                    List.of(new StringValue(columnName)))
                    ).orElse(0L));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public float getFloat(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getFloat(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnFloatResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getFloat",
                                    List.of(new StringValue(columnName)))
                    ).orElse(0.0f));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public double getDouble(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getDouble(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnDoubleResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getDouble",
                                    List.of(new StringValue(columnName)))
                    ).orElse(0.0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final String columnName, final int scale) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBigDecimal(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBigDecimalResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBigDecimal",
                                    List.of(new StringValue(columnName), new IntegerValue(scale)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable byte[] getBytes(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBytes(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnByteArrayResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBytes",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Date getDate(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getDate(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnDateResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getDate",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Time getTime(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getTime(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnTimeResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getTime",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable Timestamp getTimestamp(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getTimestamp(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnTimestampResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getTimestamp",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public InputStream getAsciiStream(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getUnicodeStream(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getBinaryStream(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
    public String getCursorName() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int findColumn(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.findColumn(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "findColumn",
                                    List.of(new StringValue(columnName)))
                    ).orElse(0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public Reader getCharacterStream(int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getCharacterStream(String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final int columnIndex) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBigDecimal(columnIndex))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBigDecimalResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBigDecimal",
                                    List.of(new IntegerValue(columnIndex)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final String columnName) throws SQLException {
        try {
            return optTableResultSet
                    .map(tableResultSet -> tableResultSet.getBigDecimal(columnName))
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBigDecimalResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getBigDecimal",
                                    List.of(new StringValue(columnName)))
                    ).orElse(null));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::isBeforeFirst)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "isBeforeFirst")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::isAfterLast)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "isAfterFirst")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isFirst() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::isFirst)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "isFirst")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean isLast() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::isLast)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "isLast")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void beforeFirst() throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(TableResultSet::beforeFirst, () ->
                    optResultSetMock.ifPresent(resultSetMock -> expectations.match(RESULT_SET, resultSetMock.getName(), "beforeFirst")));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void afterLast() throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(TableResultSet::afterLast, () ->
                    optResultSetMock.ifPresent(resultSetMock -> expectations.match(RESULT_SET, resultSetMock.getName(), "afterLast")));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean first() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::first)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "first")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean last() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::last)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "last")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getRow() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::getRow)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getRow")
                    ).orElse(-1));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public boolean absolute(final int row) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean relative(final int rows) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean previous() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::previous)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnBooleanResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "previous")
                    ).orElse(false));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.setFetchDirection(direction), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(RESULT_SET, resultSetMock.getName(), "setFetchDirection", List.of(new IntegerValue(direction)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getFetchDirection() throws SQLException {
        try {
            //noinspection MagicConstant
            return optTableResultSet
                    .map(TableResultSet::getFetchDirection)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getFetchDirection")
                    ).orElse(ResultSet.FETCH_FORWARD));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void setFetchSize(final int rows) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.setFetchSize(rows), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(RESULT_SET, resultSetMock.getName(), "setFetchSize", List.of(new IntegerValue(rows)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getFetchSize() throws SQLException {
        try {
            return optTableResultSet
                    .map(TableResultSet::getFetchSize)
                    .orElse(optResultSetMock.flatMap(resultSetMock ->
                            expectations.matchAndReturnIntegerResult(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "getFetchSize")
                    ).orElse(0));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public int getType() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getConcurrency() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowInserted() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {

    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {

    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {

    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {

    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {

    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {

    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {

    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {

    }

    @Override
    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {

    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {

    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {

    }

    @Override
    public void updateDate(int columnIndex, Date x) throws SQLException {

    }

    @Override
    public void updateTime(int columnIndex, Time x) throws SQLException {

    }

    @Override
    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {

    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final int columnIndex, final Object x, final int scaleOrLength) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final int columnIndex, final Object x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNull(final String columnName) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateNull(columnName), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(RESULT_SET, resultSetMock.getName(), "updateNull", List.of(new StringValue(columnName)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateBoolean(final String columnName, final boolean value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateBoolean(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateBoolean", List.of(new StringValue(columnName), new BooleanValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateByte(final String columnName, final byte value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateByte(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateByte", List.of(new StringValue(columnName), new ByteValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateShort(final String columnName, final short value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateShort(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateShort", List.of(new StringValue(columnName), new ShortValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateInt(final String columnName, final int value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateInt(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateInt", List.of(new StringValue(columnName), new IntegerValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateLong(final String columnName, final long value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateLong(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateLong", List.of(new StringValue(columnName), new LongValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateFloat(final String columnName, final float value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateFloat(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateFloat", List.of(new StringValue(columnName), new FloatValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateDouble(final String columnName, final double value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateDouble(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateDouble", List.of(new StringValue(columnName), new DoubleValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateBigDecimal(final String columnName, final BigDecimal value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateBigDecimal(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateBigDecimal", List.of(new StringValue(columnName), new BigDecimalValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateString(final String columnName, final String value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateString(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateString", List.of(new StringValue(columnName), new StringValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateBytes(final String columnName, final byte[] value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateBytes(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateBytes", List.of(new StringValue(columnName), new ByteArrayValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateDate(final String columnName, final Date value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateDate(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateDate", List.of(new StringValue(columnName), new DateValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateTime(final String columnName, final Time value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateTime(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateTime", List.of(new StringValue(columnName), new TimeValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateTimestamp(final String columnName, final Timestamp value) throws SQLException {
        try {
            optTableResultSet.ifPresentOrElse(tableResultSet -> tableResultSet.updateTimestamp(columnName, value), () ->
                    optResultSetMock.ifPresent(resultSetMock ->
                            expectations.match(
                                    RESULT_SET,
                                    resultSetMock.getName(),
                                    "updateTimestamp", List.of(new StringValue(columnName), new TimestampValue(value)))));
        } catch (final MockDbTableResultSetException exception) {
            throw new SQLException();
        }
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final String columnName, final Object x, final int scaleOrLength) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final String columnName, final Object x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void insertRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void deleteRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void refreshRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Statement getStatement() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int columnIndex, final Map<String, Class<?>> map) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String columnName, final Map<String, Class<?>> map) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final int columnIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final String columnName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final int columnIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final String columnName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final String columnName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRef(final int columnIndex, final Ref x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRef(final String columnName, final Ref x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final Blob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final Blob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Clob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final String columnName, final Clob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateArray(final int columnIndex, final Array x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateArray(final String columnName, final Array x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRowId(final int columnIndex, final RowId x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRowId(final String columnName, final RowId x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getHoldability() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isClosed() throws SQLException {
        // TODO: implement
        return false;
    }

    @Override
    public void updateNString(final int columnIndex, final String nString) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNString(final String columnName, final String nString) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final NClob nClob) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final NClob nClob) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateSQLXML(final int columnIndex, final SQLXML xmlObject) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateSQLXML(final String columnName, final SQLXML xmlObject) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final int columnIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final String columnName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final String columnName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final InputStream inputStream, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final String columnName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final String columnName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final InputStream inputStream) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final String columnName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final int columnIndex, final Class<T> type) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final String columnName, final Class<T> type) throws SQLException {
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
