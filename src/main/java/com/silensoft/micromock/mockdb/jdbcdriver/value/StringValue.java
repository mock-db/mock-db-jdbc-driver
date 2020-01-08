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
public class StringValue implements Value {

    private static final String NULL = "null";

    private final @NotNull String value;

    public StringValue(final @NotNull String newValue) {
        value = newValue;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof StringValue) {
            final @NotNull Optional<String> optOtherValue =  ((Value) object).getString();
            return optOtherValue.map(value::equals).orElse(NULL.equals(value));
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got string");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        throw new MockDbResultTypeException("Requires regex, got sring");
    }

    @Override
    public @NotNull Optional<String> getString() {
        return Optional.of(value);
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got string");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got string");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got string");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got string");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got string");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got string");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got string");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got string");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got string");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got string");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got string");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got string");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got string");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got string");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of(ValueType.STRING.toString());
    }
}
