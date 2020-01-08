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
public class IntegerArrayValue implements Value {
    private final @NotNull int[] value;

    public IntegerArrayValue(final @NotNull int[] newValue) {
        value = newValue.clone();
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof IntegerArrayValue) {
            final @NotNull Optional<int[]> optOtherValue =  ((Value) object).getIntegerArray();
            return optOtherValue.map(otherValue -> Arrays.equals(value, otherValue)).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got integer array");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got integer array");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got integer array");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got integer array");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got integer array");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got integer array");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got integer array");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got integer array");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got integer array");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got integer array");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got integer array");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got integer array");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got integer array");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got integer array");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got integer array");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got integer array");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.INTEGER_ARRAY.toString());
    }
}