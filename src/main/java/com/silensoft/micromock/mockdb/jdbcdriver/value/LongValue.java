package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbResultTypeException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class LongValue implements Value {
    private final long value;

    public LongValue(final long newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Value) {
            final @NotNull Optional<Long> optOtherValue =  ((Value) object).getLong();
            return optOtherValue.map(otherValue -> otherValue == value).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got long");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got long");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got long");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got integer");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        if (value >= (long) Integer.MIN_VALUE && value <= (long) Integer.MAX_VALUE) {
            return Optional.of((int) value);
        }
        throw new MockDbResultTypeException("Requires integer, got long");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        if (value >= (long) Byte.MIN_VALUE && value <= (long) Byte.MAX_VALUE) {
            return Optional.of((byte) value);
        }
        throw new MockDbResultTypeException("Requires byte, got long");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        if (value >= (long) Short.MIN_VALUE && value <= (long) Short.MAX_VALUE) {
            return Optional.of((short) value);
        }
        throw new MockDbResultTypeException("Requires byte, got long");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got long");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got long");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got long");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got long");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got long");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got long");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got long");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got long");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got long");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.LONG.toString());
    }
}
