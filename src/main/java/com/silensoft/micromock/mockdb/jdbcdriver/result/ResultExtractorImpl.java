package com.silensoft.micromock.mockdb.jdbcdriver.result;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class ResultExtractorImpl implements ResultExtractor {

    private final @NotNull Value result;

    public ResultExtractorImpl(final @NotNull Value newResult) {
        result = newResult;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        return result.getMock();
    }

    @Override
    public @NotNull Optional<String> extractString() {
        return result.getString();
    }

    @Override
    public @NotNull Optional<Boolean> extractBoolean() {
        return result.getBoolean();
    }

    @Override
    public @NotNull Optional<Integer> extractInteger() {
        return result.getInteger();
    }

    @Override
    public @NotNull Optional<Byte> extractByte() {
        return result.getByte();
    }

    @Override
    public @NotNull Optional<Short> extractShort() {
        return result.getShort();
    }

    @Override
    public @NotNull Optional<Long> extractLong() {
        return result.getLong();
    }

    @Override
    public @NotNull Optional<Double> extractDouble() {
        return result.getDouble();
    }

    @Override
    public @NotNull Optional<Float> extractFloat() {
        return result.getFloat();
    }

    @Override
    public @NotNull Optional<byte[]> extractByteArray() {
        return result.getByteArray();
    }

    @Override
    public @NotNull Optional<BigDecimal> extractBigDecimal() {
        return result.getBigDecimal();
    }

    @Override
    public @NotNull Optional<Date> extractDate() {
        return result.getDate();
    }

    @Override
    public @NotNull Optional<Time> extractTime() {
        return result.getTime();
    }

    @Override
    public @NotNull Optional<Timestamp> extractTimestamp() {
        return result.getTimestamp();
    }

    @Override
    public @NotNull Optional<int[]> extractIntegerArray() {
        return result.getIntegerArray();
    }

    @Override
    public @NotNull Optional<String[]> extractStringArray() {
        return result.getStringArray();
    }
}
