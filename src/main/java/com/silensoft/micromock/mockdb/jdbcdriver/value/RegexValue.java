package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbResultTypeException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.sun.jdi.ByteValue;
import com.sun.jdi.ShortValue;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class RegexValue implements Value {

    private static final String NULL = "null";
    private static final String FALSE = "false";
    private static final String ZERO = "0";
    private static final String LONG_ZERO = "0L";
    private static final String FLOAT_ZERO = "0.0f";
    private static final String DOUBLE_ZERO = "0.0";

    private final @NotNull String regex;

    public RegexValue(final @NotNull String newRegex) {
        regex = newRegex;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof StringValue) {
            final @NotNull Optional<String> optOtherValue =  ((Value) object).getString();
            return optOtherValue.map(regex::matches).orElse(regex.matches(NULL));
        } else if (object instanceof BooleanValue) {
            final @NotNull Optional<Boolean> optOtherValue =  ((Value) object).getBoolean();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(FALSE));
        } else if (object instanceof IntegerValue) {
            final @NotNull Optional<Integer> optOtherValue = ((Value) object).getInteger();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(ZERO));
        } else if (object instanceof ByteValue) {
            final @NotNull Optional<Byte> optOtherValue = ((Value) object).getByte();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(ZERO));
        } else if (object instanceof ShortValue) {
            final @NotNull Optional<Short> optOtherValue = ((Value) object).getShort();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(ZERO));
        } else if (object instanceof LongValue) {
            final @NotNull Optional<Long> optOtherValue = ((Value) object).getLong();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(LONG_ZERO));
        } else if (object instanceof FloatValue) {
            final @NotNull Optional<Float> optOtherValue = ((Value) object).getFloat();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(FLOAT_ZERO));
        } else if (object instanceof DoubleValue) {
            final @NotNull Optional<Double> optOtherValue = ((Value) object).getDouble();
            //noinspection ConstantConditions
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(FLOAT_ZERO));
        } else if (object instanceof BigDecimalValue) {
            final @NotNull Optional<BigDecimal> optOtherValue = ((Value) object).getBigDecimal();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(DOUBLE_ZERO));
        } else if (object instanceof ByteArrayValue) {
            final @NotNull Optional<byte[]> optOtherValue = ((Value) object).getByteArray();
            return optOtherValue.map(otherValue -> regex.matches(Arrays.toString(otherValue))).orElse(regex.matches(NULL));
        } else if (object instanceof IntegerArrayValue) {
            final @NotNull Optional<int[]> optOtherValue = ((Value) object).getIntegerArray();
            return optOtherValue.map(otherValue -> regex.matches(Arrays.toString(otherValue))).orElse(regex.matches(NULL));
        } else if (object instanceof StringArrayValue) {
            final @NotNull Optional<String[]> optOtherValue = ((Value) object).getStringArray();
            return optOtherValue.map(otherValue -> regex.matches(Arrays.toString(otherValue))).orElse(regex.matches(NULL));
        } else if (object instanceof DateValue) {
            final @NotNull Optional<Date> optOtherValue = ((Value) object).getDate();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(NULL));
        } else if (object instanceof TimeValue) {
            final @NotNull Optional<Time> optOtherValue = ((Value) object).getTime();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(NULL));
        } else if (object instanceof TimestampValue) {
            final @NotNull Optional<Timestamp> optOtherValue = ((Value) object).getTimestamp();
            return optOtherValue.map(otherValue -> regex.matches(otherValue.toString())).orElse(regex.matches(NULL));
        }

        return false;
    }

    @Override
    public @NotNull Optional<Mock> getMock() {
        throw new MockDbResultTypeException("Requires mock, got regex");
    }

    @Override
    public @NotNull Optional<String> getRegex() {
        return Optional.of(regex);
    }

    @Override
    public @NotNull Optional<String> getString() {
        throw new MockDbResultTypeException("Requires string, got regex");
    }

    @Override
    public @NotNull Optional<Boolean> getBoolean() {
        throw new MockDbResultTypeException("Requires boolean, got regex");
    }

    @Override
    public @NotNull Optional<Integer> getInteger() {
        throw new MockDbResultTypeException("Requires integer, got regex");
    }

    @Override
    public @NotNull Optional<Byte> getByte() {
        throw new MockDbResultTypeException("Requires byte, got regex");
    }

    @Override
    public @NotNull Optional<Short> getShort() {
        throw new MockDbResultTypeException("Requires short, got regex");
    }

    @Override
    public @NotNull Optional<Long> getLong() {
        throw new MockDbResultTypeException("Requires long, got regex");
    }

    @Override
    public @NotNull Optional<Double> getDouble() {
        throw new MockDbResultTypeException("Requires double, got regex");
    }

    @Override
    public @NotNull Optional<Float> getFloat() {
        throw new MockDbResultTypeException("Requires float, got regex");
    }

    @Override
    public @NotNull Optional<byte[]> getByteArray() {
        throw new MockDbResultTypeException("Requires byte array, got regex");
    }

    @Override
    public @NotNull Optional<BigDecimal> getBigDecimal() {
        throw new MockDbResultTypeException("Requires big decimal, got regex");
    }

    @Override
    public @NotNull Optional<Date> getDate() {
        throw new MockDbResultTypeException("Requires date, got regex");
    }

    @Override
    public @NotNull Optional<Time> getTime() {
        throw new MockDbResultTypeException("Requires time, got regex");
    }

    @Override
    public @NotNull Optional<Timestamp> getTimestamp() {
        throw new MockDbResultTypeException("Requires timestamp, got regex");
    }

    @Override
    public @NotNull Optional<int[]> getIntegerArray() {
        throw new MockDbResultTypeException("Requires integer array, got regex");
    }

    @Override
    public @NotNull Optional<String[]> getStringArray() {
        throw new MockDbResultTypeException("Requires string array, got regex");
    }

    @Override
    public @NotNull Optional<String> getClassName() {
        return Optional.of("Regex");
    }
}
