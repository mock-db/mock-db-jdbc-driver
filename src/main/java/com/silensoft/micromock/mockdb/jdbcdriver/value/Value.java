package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public interface Value {
    @NotNull Optional<Mock> getMock();
    @NotNull Optional<String> getRegex();
    @NotNull Optional<String> getString();
    @NotNull Optional<Boolean> getBoolean();
    @NotNull Optional<Integer> getInteger();
    @NotNull Optional<Byte> getByte();
    @NotNull Optional<Short> getShort();
    @NotNull Optional<Long> getLong();
    @NotNull Optional<Double> getDouble();
    @NotNull Optional<Float> getFloat();
    @NotNull Optional<byte[]> getByteArray();
    @NotNull Optional<BigDecimal> getBigDecimal();
    @NotNull Optional<Date> getDate();
    @NotNull Optional<Time> getTime();
    @NotNull Optional<Timestamp> getTimestamp();
    @NotNull Optional<int[]> getIntegerArray();
    @NotNull Optional<String[]> getStringArray();
    @NotNull Optional<String> getClassName();
}
