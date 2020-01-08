package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RowImpl implements Row {
    private static final String NULL_STRING = "null";

    private final @NotNull List<@NotNull String> cells;

    public RowImpl(final @NotNull List<@NotNull String> newCells) {
        cells = new ArrayList<>(newCells);
    }

    @Override
    public @Nullable String getString(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? cells.get(columnIndex) : null;
    }

    @Override
    public boolean getBoolean(final @Nullable Integer columnIndex) {
        return (columnIndex != null && NULL_STRING.equals(cells.get(columnIndex))) && Boolean.parseBoolean(cells.get(columnIndex));
    }

    @Override
    public byte getByte(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Byte.parseByte(cells.get(columnIndex)) : (byte) 0;
    }

    @Override
    public short getShort(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Short.parseShort(cells.get(columnIndex)) : (short) 0;
    }

    @Override
    public int getInteger(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Integer.parseInt(cells.get(columnIndex)) : 0;
    }

    @Override
    public long getLong(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Long.parseLong(cells.get(columnIndex)) : 0L;
    }

    @Override
    public float getFloat(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Float.parseFloat(cells.get(columnIndex)) : 0.0f;
    }

    @Override
    public double getDouble(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Double.parseDouble(cells.get(columnIndex)) : 0.0;
    }

    @Override
    public @Nullable BigDecimal getBigDecimal(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? new BigDecimal(cells.get(columnIndex)) : BigDecimal.ZERO;
    }

    @Override
    public @Nullable byte[] getBytes(final @Nullable Integer columnIndex) {
        try {
            return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Hex.decodeHex(cells.get(columnIndex).toCharArray()): null;
        } catch (final DecoderException exception) {
            return null;
        }
    }

    @Override
    public @Nullable Date getDate(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Date.valueOf(cells.get(columnIndex)) : null;
    }

    @Override
    public @Nullable Time getTime(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Time.valueOf(cells.get(columnIndex)) : null;
    }

    @Override
    public @Nullable Timestamp getTimestamp(final @Nullable Integer columnIndex) {
        return columnIndex != null && !NULL_STRING.equals(cells.get(columnIndex)) ? Timestamp.valueOf(cells.get(columnIndex)) : null;
    }

    @Override
    public void updateNull(final @Nullable Integer columnIndex) {
        if (columnIndex != null) {
            cells.set(columnIndex, "null");
        }
    }

    @Override
    public void updateString(final @Nullable Integer columnIndex, final String value) {
        if (columnIndex != null) {
            cells.set(columnIndex, value);
        }
    }

    @SuppressWarnings("BooleanParameter")
    @Override
    public void updateBoolean(final @Nullable Integer columnIndex, final boolean value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf(value));
        }
    }

    @Override
    public void updateByte(final @Nullable Integer columnIndex, final byte value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf((int) value));
        }
    }

    @Override
    public void updateShort(final @Nullable Integer columnIndex, final short value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf((int) value));
        }
    }

    @Override
    public void updateInteger(final @Nullable Integer columnIndex, final int value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf(value));
        }
    }

    @Override
    public void updateLong(final @Nullable Integer columnIndex, final long value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf(value));
        }
    }

    @Override
    public void updateFloat(final @Nullable Integer columnIndex, final float value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf(value));
        }
    }

    @Override
    public void updateDouble(final @Nullable Integer columnIndex, final double value) {
        if (columnIndex != null) {
            cells.set(columnIndex, String.valueOf(value));
        }
    }

    @Override
    public void updateBigDecimal(final @Nullable Integer columnIndex, final BigDecimal value) {
        if (columnIndex != null) {
            cells.set(columnIndex, value.toString());
        }
    }

    @Override
    public void updateBytes(final @Nullable Integer columnIndex, final byte[] value) {
        if (columnIndex != null) {
            final String valueString = new String(Hex.encodeHex(value));
            cells.set(columnIndex, valueString);
        }
    }

    @Override
    public void updateDate(final @Nullable Integer columnIndex, final Date value) {
        if (columnIndex != null) {
            cells.set(columnIndex, value.toString());
        }
    }

    @SuppressWarnings("CallToTimeToString")
    @Override
    public void updateTime(final @Nullable Integer columnIndex, final Time value) {
        if (columnIndex != null) {
            cells.set(columnIndex, value.toString());
        }
    }

    @Override
    public void updateTimestamp(final @Nullable Integer columnIndex, final Timestamp value) {
        if (columnIndex != null) {
            cells.set(columnIndex, value.toString());
        }
    }
}
