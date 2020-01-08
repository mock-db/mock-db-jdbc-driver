package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbResultTypeException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class ByteArrayValue implements Value {

    private final @NotNull byte[] value;

    public ByteArrayValue(final @NotNull byte[] newValue) {
        value = newValue.clone();
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof ByteArrayValue) {
            final @NotNull Optional<byte[]> optOtherValue =  ((Value) object).getByteArray();
            return optOtherValue.map(otherValue -> Arrays.equals(value, otherValue)).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got byte array");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got byte array");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got byte array");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got byte array");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got byte array");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got byte array");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got byte array");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got byte array");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got byte array");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got byte array");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got byte array");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got byte array");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got byte array");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got byte array");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got byte array");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got byte array");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.BYTE_ARRAY.toString());
    }
}
