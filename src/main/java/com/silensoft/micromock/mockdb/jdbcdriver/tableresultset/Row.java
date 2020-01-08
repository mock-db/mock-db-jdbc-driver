package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public interface Row {
    String getString(final @Nullable Integer columnIndex);
    boolean getBoolean(final @Nullable Integer columnIndex);
    byte getByte(final @Nullable Integer columnIndex);
    short getShort(final @Nullable Integer columnIndex);
    int getInteger(final @Nullable Integer columnIndex);
    long getLong(final @Nullable Integer columnIndex);
    float getFloat(final @Nullable Integer columnIndex);
    double getDouble(final @Nullable Integer columnIndex);
    BigDecimal getBigDecimal(final @Nullable Integer columnIndex);
    byte[] getBytes(final @Nullable Integer columnIndex);
    Date getDate(final @Nullable Integer columnIndex);
    Time getTime(final @Nullable Integer columnIndex);
    Timestamp getTimestamp(final @Nullable Integer columnIndex);

    void updateNull(final @Nullable Integer columnIndex);
    void updateString(final @Nullable Integer columnIndex, final String value);
    void updateBoolean(final @Nullable Integer columnIndex, final boolean value);
    void updateByte(final @Nullable Integer columnIndex, final byte value);
    void updateShort(final @Nullable Integer  columnIndex, final short value);
    void updateInteger(final @Nullable Integer columnIndex, final int value);
    void updateLong(final @Nullable Integer columnIndex, final long value);
    void updateFloat(final @Nullable Integer columnIndex, final float value);
    void updateDouble(final @Nullable Integer columnIndex, final double value);
    void updateBigDecimal(final @Nullable Integer columnIndex, final BigDecimal value);
    void updateBytes(final @Nullable Integer columnIndex, final byte[] value);
    void updateDate(final @Nullable Integer columnIndex, final Date value);
    void updateTime(final @Nullable Integer columnIndex, final Time value);
    void updateTimestamp(final @Nullable Integer columnIndex, final Timestamp value);
}
