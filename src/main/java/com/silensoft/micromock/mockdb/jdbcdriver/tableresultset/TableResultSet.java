package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

 public interface TableResultSet {
    boolean next();

    void close();

    boolean wasNull();

    String getString(int columnIndex);

    boolean getBoolean(int columnIndex);

    byte getByte(int columnIndex);

    short getShort(int columnIndex);

    int getInt(int columnIndex);

    long getLong(int columnIndex);

    float getFloat(int columnIndex);

    double getDouble(int columnIndex);

    BigDecimal getBigDecimal(int columnIndex, int scale);

    byte[] getBytes(int columnIndex);

    Date getDate(int columnIndex);

    Time getTime(int columnIndex);

    Timestamp getTimestamp(int columnIndex);

    InputStream getAsciiStream(int columnIndex);

    InputStream getUnicodeStream(int columnIndex);

    InputStream getBinaryStream(int columnIndex);

    String getString(String columnName);

    boolean getBoolean(String columnName);

    byte getByte(String columnName);

    short getShort(String columnName);

    int getInt(String columnName);

    long getLong(String columnName);

    float getFloat(String columnName);

    double getDouble(String columnName);

    BigDecimal getBigDecimal(String columnName, int scale);

    byte[] getBytes(String columnName);

    Date getDate(String columnName);

    Time getTime(String columnName);

    Timestamp getTimestamp(String columnName);

    InputStream getAsciiStream(String columnName);

    InputStream getUnicodeStream(String columnName);

    InputStream getBinaryStream(String columnName);

    SQLWarning getWarnings();

    void clearWarnings();

    String getCursorName();

    ResultSetMetaData getMetaData();

    Object getObject(int columnIndex);

    Object getObject(String columnName);

    int findColumn(String columnName);

    Reader getCharacterStream(int columnIndex);

    Reader getCharacterStream(String columnName);

    BigDecimal getBigDecimal(int columnIndex);

    BigDecimal getBigDecimal(String columnName);

    boolean isBeforeFirst();

    boolean isAfterLast();

    boolean isFirst();

    boolean isLast();

    void beforeFirst();

    void afterLast();

    boolean first();

    boolean last();

    int getRow();

    boolean absolute(int row);

    boolean relative(int rows);

    boolean previous();

    void setFetchDirection(int direction);

    int getFetchDirection();

    void setFetchSize(int rows);

    int getFetchSize();

    int getType();

    int getConcurrency();

    boolean rowUpdated();

    boolean rowInserted();

    boolean rowDeleted();

    void updateNull(int columnIndex);

    void updateBoolean(int columnIndex, boolean x);

    void updateByte(int columnIndex, byte x);

    void updateShort(int columnIndex, short x);

    void updateInt(int columnIndex, int x);

    void updateLong(int columnIndex, long x);

    void updateFloat(int columnIndex, float x);

    void updateDouble(int columnIndex, double x);

    void updateBigDecimal(int columnIndex, BigDecimal x);

    void updateString(int columnIndex, String x);

    void updateBytes(int columnIndex, byte[] x);

    void updateDate(int columnIndex, Date x);

    void updateTime(int columnIndex, Time x);

    void updateTimestamp(int columnIndex, Timestamp x);

    void updateAsciiStream(int columnIndex, InputStream x, int length);

    void updateBinaryStream(int columnIndex, InputStream x, int length);

    void updateCharacterStream(int columnIndex, Reader x, int length);

    void updateObject(int columnIndex, Object x, int scaleOrLength);

    void updateObject(int columnIndex, Object x);

    void updateNull(String columnName);

    void updateBoolean(String columnName, boolean x);

    void updateByte(String columnName, byte x);

    void updateShort(String columnName, short x);

    void updateInt(String columnName, int x);

    void updateLong(String columnName, long x);

    void updateFloat(String columnName, float x);

    void updateDouble(String columnName, double x);

    void updateBigDecimal(String columnName, BigDecimal x);

    void updateString(String columnName, String x);

    void updateBytes(String columnName, byte[] x);

    void updateDate(String columnName, Date x);

    void updateTime(String columnName, Time x);

    void updateTimestamp(String columnName, Timestamp x);

    void updateAsciiStream(String columnName, InputStream x, int length);

    void updateBinaryStream(String columnName, InputStream x, int length);

    void updateCharacterStream(String columnName, Reader reader, int length);

    void updateObject(String columnName, Object x, int scaleOrLength);

    void updateObject(String columnName, Object x);

    void insertRow();

    void updateRow();

    void deleteRow();

    void refreshRow();

    void cancelRowUpdates();

    void moveToInsertRow();

    void moveToCurrentRow();

    Statement getStatement();

    Object getObject(int columnIndex, Map<String, Class<?>> map);

    Ref getRef(int columnIndex);

    Blob getBlob(int columnIndex);

    Clob getClob(int columnIndex);

    Array getArray(int columnIndex);

    Object getObject(String columnName, Map<String, Class<?>> map);

    Ref getRef(String columnName);

    Blob getBlob(String columnName);

    Clob getClob(String columnName);

    Array getArray(String columnName);

    Date getDate(int columnIndex, Calendar cal);

    Date getDate(String columnName, Calendar cal);

    Time getTime(int columnIndex, Calendar cal);

    Time getTime(String columnName, Calendar cal);

    Timestamp getTimestamp(int columnIndex, Calendar cal);

    Timestamp getTimestamp(String columnName, Calendar cal);

    URL getURL(int columnIndex);

    URL getURL(String columnName);

    void updateRef(int columnIndex, Ref x);

    void updateRef(String columnName, Ref x);

    void updateBlob(int columnIndex, Blob x);

    void updateBlob(String columnName, Blob x);

    void updateClob(int columnIndex, Clob x);

    void updateClob(String columnName, Clob x);

    void updateArray(int columnIndex, Array x);

    void updateArray(String columnName, Array x);

    RowId getRowId(int columnIndex);

    RowId getRowId(String columnName);

    void updateRowId(int columnIndex, RowId x);

    void updateRowId(String columnName, RowId x);

    int getHoldability();

    boolean isClosed();

    void updateNString(int columnIndex, String nString);

    void updateNString(String columnName, String nString);

    void updateNClob(int columnIndex, NClob nClob);

    void updateNClob(String columnName, NClob nClob);

    NClob getNClob(int columnIndex);

    NClob getNClob(String columnName);

    SQLXML getSQLXML(int columnIndex);

    SQLXML getSQLXML(String columnName);

    void updateSQLXML(int columnIndex, SQLXML xmlObject);

    void updateSQLXML(String columnName, SQLXML xmlObject);

    String getNString(int columnIndex);

    String getNString(String columnName);

    Reader getNCharacterStream(int columnIndex);

    Reader getNCharacterStream(String columnName);

    void updateNCharacterStream(int columnIndex, Reader x, long length);

    void updateNCharacterStream(String columnName, Reader reader, long length);

    void updateAsciiStream(int columnIndex, InputStream x, long length);

    void updateBinaryStream(int columnIndex, InputStream x, long length);

    void updateCharacterStream(int columnIndex, Reader x, long length);

    void updateAsciiStream(String columnName, InputStream x, long length);

    void updateBinaryStream(String columnName, InputStream x, long length);

    void updateCharacterStream(String columnName, Reader reader, long length);

    void updateBlob(int columnIndex, InputStream inputStream, long length);

    void updateBlob(String columnName, InputStream inputStream, long length);

    void updateClob(int columnIndex, Reader reader, long length);

    void updateClob(String columnName, Reader reader, long length);

    void updateNClob(int columnIndex, Reader reader, long length);

    void updateNClob(String columnName, Reader reader, long length);

    void updateNCharacterStream(int columnIndex, Reader x);

    void updateNCharacterStream(String columnName, Reader reader);

    void updateAsciiStream(int columnIndex, InputStream x);

    void updateBinaryStream(int columnIndex, InputStream x);

    void updateCharacterStream(int columnIndex, Reader x);

    void updateAsciiStream(String columnName, InputStream x);

    void updateBinaryStream(String columnName, InputStream x);

    void updateCharacterStream(String columnName, Reader reader);

    void updateBlob(int columnIndex, InputStream inputStream);

    void updateBlob(String columnName, InputStream inputStream);

    void updateClob(int columnIndex, Reader reader);

    void updateClob(String columnName, Reader reader);

    void updateNClob(int columnIndex, Reader reader);

    void updateNClob(String columnName, Reader reader);

    <T> T getObject(int columnIndex, Class<T> type);

    <T> T getObject(String columnName, Class<T> type);

    <T> T unwrap(Class<T> iface);

    boolean isWrapperFor(Class<?> iface);
 }