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
public class ShortValue implements Value {
    private final short value;

    public ShortValue(final short newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Value) {
            final @NotNull Optional<Short> optOtherValue =  ((Value) object).getShort();
            return optOtherValue.map(otherValue -> otherValue == value).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got short");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got short");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got short");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got short");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        return Optional.of((int) value);
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        if (value >= (int) Byte.MIN_VALUE && value <= (int) Byte.MAX_VALUE) {
            return Optional.of((byte) value);
        }
        throw new MockDbResultTypeException("Requires byte, got short");

    }

    @Override
    public @NotNull Optional<Short> getShort() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        return Optional.of((long) value);
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got short");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires double, got short");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got short");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got short");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got short");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got short");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got short");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got short");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got short");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.SHORT.toString());
    }
}
