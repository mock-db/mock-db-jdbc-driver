package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

public class MockDbCallableStatement implements CallableStatement {
    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> callableStatementMock;

    public MockDbCallableStatement(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newCallableStatementMock) {
        expectations = newExpectations;
        callableStatementMock = newCallableStatementMock;
    }

    @Override
    public void registerOutParameter(final int parameterIndex, final int sqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void registerOutParameter(final int parameterIndex, final int sqlType, final int scale) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean wasNull() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getString(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean getBoolean(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public byte getByte(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public short getShort(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getInt(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public long getLong(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public float getFloat(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public double getDouble(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public BigDecimal getBigDecimal(final int parameterIndex, final int scale) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public byte[] getBytes(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public BigDecimal getBigDecimal(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final int parameterIndex, final Map<String, Class<?>> map) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final int parameterIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final int parameterIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final int parameterIndex, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void registerOutParameter(final int parameterIndex, final int sqlType, final String typeName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void registerOutParameter(final String parameterName, final int sqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void registerOutParameter(final String parameterName, final int sqlType, final int scale) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void registerOutParameter(final String parameterName, final int sqlType, final String typeName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setURL(final String parameterName, final URL val) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNull(final String parameterName, final int sqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBoolean(final String parameterName, final boolean x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setByte(final String parameterName, final byte x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setShort(final String parameterName, final short x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setInt(final String parameterName, final int x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setLong(final String parameterName, final long x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setFloat(final String parameterName, final float x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDouble(final String parameterName, final double x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBigDecimal(final String parameterName, final BigDecimal x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setString(final String parameterName, final String x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBytes(final String parameterName, final byte[] x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDate(final String parameterName, final Date x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTime(final String parameterName, final Time x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTimestamp(final String parameterName, final Timestamp x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setAsciiStream(final String parameterName, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final String parameterName, final InputStream x, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final String parameterName, final Object x, final int targetSqlType, final int scale) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final String parameterName, final Object x, final int targetSqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final String parameterName, final Object x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCharacterStream(final String parameterName, final Reader reader, final int length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDate(final String parameterName, final Date x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTime(final String parameterName, final Time x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTimestamp(final String parameterName, final Timestamp x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNull(final String parameterName, final int sqlType, final String typeName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getString(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean getBoolean(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public byte getByte(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public short getShort(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int getInt(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public long getLong(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public float getFloat(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public double getDouble(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public byte[] getBytes(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public BigDecimal getBigDecimal(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Object getObject(final String parameterName, final Map<String, Class<?>> map) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Ref getRef(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Blob getBlob(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Clob getClob(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Array getArray(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Date getDate(final String parameterName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Time getTime(final String parameterName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Timestamp getTimestamp(final String parameterName, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public URL getURL(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public RowId getRowId(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setRowId(final String parameterName, final RowId x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNString(final String parameterName, final String value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNCharacterStream(final String parameterName, final Reader value, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final String parameterName, final NClob value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final String parameterName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final String parameterName, final InputStream inputStream, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final String parameterName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public NClob getNClob(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setSQLXML(final String parameterName, final SQLXML xmlObject) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public SQLXML getSQLXML(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public String getNString(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getNCharacterStream(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getCharacterStream(final int parameterIndex) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public Reader getCharacterStream(final String parameterName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final String parameterName, final Blob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final String parameterName, final Clob x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setAsciiStream(final String parameterName, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final String parameterName, final InputStream x, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCharacterStream(final String parameterName, final Reader reader, final long length) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setAsciiStream(final String parameterName, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBinaryStream(final String parameterName, final InputStream x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setCharacterStream(final String parameterName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNCharacterStream(final String parameterName, final Reader value) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setClob(final String parameterName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBlob(final String parameterName, final InputStream inputStream) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNClob(final String parameterName, final Reader reader) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final int parameterIndex, final Class<T> type) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public <T> T getObject(final String parameterName, final Class<T> type) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int executeUpdate() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBoolean(final int parameterIndex, final boolean x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setByte(final int parameterIndex, final byte x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setShort(final int parameterIndex, final short x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setInt(final int parameterIndex, final int x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setLong(final int parameterIndex, final long x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setFloat(final int parameterIndex, final float x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDouble(final int parameterIndex, final double x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBigDecimal(final int parameterIndex, final BigDecimal x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setString(final int parameterIndex, final String x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setBytes(final int parameterIndex, byte[] x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDate(final int parameterIndex, final Date x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTime(final int parameterIndex, final Time x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final int parameterIndex, final Object x, final int targetSqlType) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setObject(final int parameterIndex, final Object x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void addBatch() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setDate(final int parameterIndex, final Date x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTime(final int parameterIndex, final Time x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setTimestamp(final int parameterIndex, final Timestamp x, final Calendar cal) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setNull(final int parameterIndex, final int sqlType, final String typeName) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void setURL(final int parameterIndex, final URL x) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public int executeUpdate(final String sql) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public void close() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
    public void setCursorName(final String name) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean execute(final String sql) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
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
