package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class AnyValue implements Value {

    @Override
    public boolean equals(final Object object) {
        return object instanceof Value;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<String> getString() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        return Optional.empty();
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.empty();
    }
}
