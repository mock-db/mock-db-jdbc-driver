package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbTableResultSetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@SuppressWarnings("UseOfObsoleteDateTimeApi")
public class TableResultSetImpl implements TableResultSet {
    private final @NotNull List<@NotNull String> columnNames;
    private final @NotNull List<@NotNull Row> rows;
    private final @NotNull Map<@NotNull String, Integer> columnNameToColumnIndexMap;

    private int currentRowIndex = -1;
    private boolean isClosed;
    private int fetchDirection = ResultSet.FETCH_FORWARD;
    private int fetchSize;

    public TableResultSetImpl(final @NotNull List<@NotNull String> newColumnNames, final @NotNull List<@NotNull Row> newRows) {
        columnNames = new ArrayList<>(newColumnNames);
        rows = new ArrayList<>(newRows);
        columnNameToColumnIndexMap = new HashMap<>(50);
        // TODO: create column name to column index map
    }

    @Override
    public boolean next()  {
        currentRowIndex++;
        return currentRowIndex < rows.size();
    }

    @Override
    public void close()  {
        isClosed = true;
    }

    @Override
    public boolean wasNull()  {
        // TODO: implement
        return false;
    }

    @Override
    public @Nullable String getString(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getString(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public boolean getBoolean(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getBoolean(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public byte getByte(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getByte(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public short getShort(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getShort(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public int getInt(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getInteger(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public long getLong(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getLong(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public float getFloat(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getFloat(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public double getDouble(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getDouble(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final int columnIndex, final int scale)  {
        try {
            // TODO: handle scale
            return rows.get(currentRowIndex).getBigDecimal(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable byte[] getBytes(int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getBytes(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Date getDate(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getDate(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Time getTime(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getTime(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Timestamp getTimestamp(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getTimestamp(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public InputStream getAsciiStream(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getUnicodeStream(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getBinaryStream(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public @Nullable String getString(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getString(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public boolean getBoolean(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getBoolean(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public byte getByte(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getByte(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public short getShort(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getShort(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public int getInt(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getInteger(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public long getLong(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getLong(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public float getFloat(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getFloat(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public double getDouble(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getDouble(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final String columnName, final int scale)  {
        try {
            // TODO: handle scale
            return rows.get(currentRowIndex).getBigDecimal(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable byte[] getBytes(String columnName)  {
        try {
            return rows.get(currentRowIndex).getBytes(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Date getDate(String columnName)  {
        try {
            return rows.get(currentRowIndex).getDate(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Time getTime(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getTime(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable Timestamp getTimestamp(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getTimestamp(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public InputStream getAsciiStream(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getUnicodeStream(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public InputStream getBinaryStream(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLWarning getWarnings()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void clearWarnings()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getCursorName()  {
        return "Default cursor";
    }

    @Override
    public ResultSetMetaData getMetaData()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int findColumn(final String columnName)  {
        try {
            //noinspection ConstantConditions
            return columnNameToColumnIndexMap.get(columnName);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public Reader getCharacterStream(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getCharacterStream(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final int columnIndex)  {
        try {
            return rows.get(currentRowIndex).getBigDecimal(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final String columnName)  {
        try {
            return rows.get(currentRowIndex).getBigDecimal(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public boolean isBeforeFirst()  {
        return currentRowIndex == -1;
    }

    @Override
    public boolean isAfterLast()  {
        return currentRowIndex >= rows.size();
    }

    @Override
    public boolean isFirst()  {
        return currentRowIndex == 0;
    }

    @Override
    public boolean isLast()  {
        return currentRowIndex == rows.size() - 1;
    }

    @Override
    public void beforeFirst()  {
        currentRowIndex = -1;
    }

    @Override
    public void afterLast()  {
        currentRowIndex = rows.size();
    }

    @Override
    public boolean first()  {
        if (rows.isEmpty()) {
            return false;
        }

        currentRowIndex = 0;
        return true;
    }

    @Override
    public boolean last()  {
        if (rows.isEmpty()) {
            return false;
        }

        currentRowIndex = rows.size() - 1;
        return true;
    }

    @Override
    public int getRow()  {
        return currentRowIndex + 1;
    }

    @Override
    public boolean absolute(final int row)  {
        // TODO: implement
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean relative(final int rows)  {
        // TODO: implement
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean previous()  {
        if (currentRowIndex == -1) {
            return false;
        }

        currentRowIndex--;
        return true;
    }

    @Override
    public void setFetchDirection(final int direction)  {
        fetchDirection = direction;
    }

    @Override
    public int getFetchDirection()  {
        return fetchDirection;
    }

    @Override
    public void setFetchSize(final int rows)  {
        fetchSize = rows;
    }

    @Override
    public int getFetchSize()  {
        return fetchSize;
    }

    @Override
    public int getType()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getConcurrency()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowUpdated()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowInserted()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean rowDeleted()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNull(final int columnIndex)  {
        try {
            rows.get(currentRowIndex).updateNull(columnIndex);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @SuppressWarnings("BooleanParameter")
    @Override
    public void updateBoolean(final int columnIndex, final boolean value)  {
        try {
            rows.get(currentRowIndex).updateBoolean(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateByte(final int columnIndex, final byte value)  {
        try {
            rows.get(currentRowIndex).updateByte(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateShort(final int columnIndex, final short value)  {
        try {
            rows.get(currentRowIndex).updateShort(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateInt(final int columnIndex, final int value)  {
        try {
            rows.get(currentRowIndex).updateInteger(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateLong(final int columnIndex, final long value)  {
        try {
            rows.get(currentRowIndex).updateLong(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateFloat(final int columnIndex, final float value)  {
        try {
            rows.get(currentRowIndex).updateFloat(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateDouble(final int columnIndex, final double value)  {
        try {
            rows.get(currentRowIndex).updateDouble(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateBigDecimal(final int columnIndex, final BigDecimal value)  {
        try {
            rows.get(currentRowIndex).updateBigDecimal(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateString(final int columnIndex, final String value)  {
        try {
            rows.get(currentRowIndex).updateString(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateBytes(final int columnIndex, final byte[] value)  {
        try {
            rows.get(currentRowIndex).updateBytes(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateDate(final int columnIndex, final Date value)  {
        try {
            rows.get(currentRowIndex).updateDate(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateTime(final int columnIndex, final Time value)  {
        try {
            rows.get(currentRowIndex).updateTime(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateTimestamp(final int columnIndex, final Timestamp value)  {
        try {
            rows.get(currentRowIndex).updateTimestamp(columnIndex, value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(int columnIndex, Object x, int scaleOrLength)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(int columnIndex, Object x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNull(final String columnName)  {
        try {
            rows.get(currentRowIndex).updateNull(columnNameToColumnIndexMap.get(columnName));
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateBoolean(final String columnName, final boolean value)  {
        try {
            rows.get(currentRowIndex).updateBoolean(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateByte(final String columnName, final byte value)  {
        try {
            rows.get(currentRowIndex).updateByte(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateShort(final String columnName, final short value)  {
        try {
            rows.get(currentRowIndex).updateShort(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateInt(final String columnName, final int value)  {
        try {
            rows.get(currentRowIndex).updateInteger(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateLong(final String columnName, final long value)  {
        try {
            rows.get(currentRowIndex).updateLong(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateFloat(final String columnName, final float value)  {
        try {
            rows.get(currentRowIndex).updateFloat(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateDouble(final String columnName, final double value)  {
        try {
            rows.get(currentRowIndex).updateDouble(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateBigDecimal(final String columnName, final BigDecimal value)  {
        try {
            rows.get(currentRowIndex).updateBigDecimal(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateString(final String columnName, final String value)  {
        try {
            rows.get(currentRowIndex).updateString(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateBytes(final String columnName, final byte[] value)  {
        try {
            rows.get(currentRowIndex).updateBytes(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateDate(final String columnName, final Date value)  {
        try {
            rows.get(currentRowIndex).updateDate(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateTime(final String columnName, final Time value)  {
        try {
            rows.get(currentRowIndex).updateTime(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateTimestamp(final String columnName, final Timestamp value)  {
        try {
            rows.get(currentRowIndex).updateTimestamp(columnNameToColumnIndexMap.get(columnName), value);
        } catch (final Exception exception) {
            throw new MockDbTableResultSetException(exception);
        }
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x, final int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x, final int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader, final int length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final String columnName, final Object x, final int scaleOrLength)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateObject(final String columnName, final Object x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void insertRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void deleteRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void refreshRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void cancelRowUpdates()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void moveToInsertRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void moveToCurrentRow()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Statement getStatement()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int columnIndex, final Map<String, Class<?>> map)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String columnName, final Map<String, Class<?>> map)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final int columnIndex, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final String columnName, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final int columnIndex, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final String columnName, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final int columnIndex, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final String columnName, final Calendar cal)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRef(final int columnIndex, final Ref x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRef(final String columnName, final Ref x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final Blob x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final Blob x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Clob x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final  String columnName, final Clob x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateArray(final int columnIndex, final Array x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateArray(final String columnName, final Array x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRowId(final int columnIndex, final RowId x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateRowId(final String columnName, final RowId x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getHoldability()  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isClosed()  {
        return isClosed;
    }

    @Override
    public void updateNString(final int columnIndex, final String nString)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNString(final String columnName, final String nString)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final NClob nClob)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final NClob nClob)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateSQLXML(final int columnIndex, final SQLXML xmlObject)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateSQLXML(final String columnName, final SQLXML xmlObject)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final int columnIndex)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final String columnName)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final String columnName, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final InputStream inputStream, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final String columnName, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final Reader reader, final long length)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNCharacterStream(final String columnName, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateAsciiStream(final String columnName, final InputStream x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBinaryStream(final String columnName, final InputStream x)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateCharacterStream(final String columnName, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateBlob(final String columnName, final InputStream inputStream)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final int columnIndex, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateClob(final String columnName, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final int columnIndex, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void updateNClob(final String columnName, final Reader reader)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final int columnIndex, final Class<T> type)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final String columnName, final Class<T> type)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T unwrap(final Class<T> iface)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface)  {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }
}
