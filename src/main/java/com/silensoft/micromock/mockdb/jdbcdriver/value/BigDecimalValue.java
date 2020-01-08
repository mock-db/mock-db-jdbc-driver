package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbResultTypeException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class BigDecimalValue implements Value {

    private final @Nullable BigDecimal value;

    public BigDecimalValue(final @Nullable BigDecimal newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Value && value != null) {
            final @NotNull Optional<BigDecimal> optOtherValue =  ((Value) object).getBigDecimal();
            return optOtherValue.map(otherValue -> value.compareTo(otherValue) == 0).orElse(false);
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got big decimal");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got big decimal");
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got big string");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got big decimal");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got big decimal");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got big decimal");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got big decimal");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got big decimal");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got big decimal");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got big decimal");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got big decimal");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        return Optional.ofNullable(value);
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got big decimal");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got big decimal");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got big decimal");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got big decimal");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got big decimal");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.BIG_DECIMAL.toString());
    }
}
