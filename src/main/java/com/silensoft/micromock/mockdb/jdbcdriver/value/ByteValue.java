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
public class ByteValue implements Value {
    private final byte value;

    public ByteValue(final byte newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Value) {
            final @NotNull Optional<Byte> optOtherValue =  ((Value) object).getByte();
            return optOtherValue.map(otherValue -> otherValue == value).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got byte");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got byte");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got byte");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got byte");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        return Optional.of((int) value);
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        return Optional.of((short) value);
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        return Optional.of((long) value);
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got byte");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires double, got byte");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got byte");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got byte");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got byte");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got byte");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires time stamp, got byte");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got byte");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got byte");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.BYTE.toString());
    }
}
