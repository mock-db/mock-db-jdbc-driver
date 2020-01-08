package com.silensoft.micromock.mockdb.jdbcdriver.result;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public interface ResultExtractor {
    @NotNull Optional<Mock> getMock();
    @NotNull Optional<String> extractString();
    @NotNull Optional<Boolean> extractBoolean();
    @NotNull Optional<Integer> extractInteger();
    @NotNull Optional<Byte> extractByte();
    @NotNull Optional<Short> extractShort();
    @NotNull Optional<Long> extractLong();
    @NotNull Optional<Float> extractFloat();
    @NotNull Optional<Double> extractDouble();
    @NotNull Optional<byte[]> extractByteArray();
    @NotNull Optional<BigDecimal> extractBigDecimal();
    @NotNull Optional<Date> extractDate();
    @NotNull Optional<Time> extractTime();
    @NotNull Optional<Timestamp> extractTimestamp();
    @NotNull Optional<int[]> extractIntegerArray();
    @NotNull Optional<String[]> extractStringArray();
}
