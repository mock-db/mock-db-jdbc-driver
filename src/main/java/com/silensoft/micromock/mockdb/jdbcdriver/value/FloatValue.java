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
public class FloatValue implements Value {
    private final float value;

    public FloatValue(final float newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Value) {
            final @NotNull Optional<Float> optOtherValue = ((Value) object).getFloat();
            return optOtherValue.map(otherValue -> Float.compare(value, otherValue) == 0).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got float");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got float");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got float");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got float");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got float");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got float");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got float");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got float");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        return Optional.of((double) value);
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got float");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got float");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got float");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got float");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got float");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got float");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got float");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.FLOAT.toString());
    }
}
