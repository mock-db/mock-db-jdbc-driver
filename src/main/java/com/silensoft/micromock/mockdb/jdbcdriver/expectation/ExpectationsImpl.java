package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueType;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import com.silensoft.micromock.mockdb.jdbcdriver.value.VoidValue;
import com.silensoft.micromock.mockdb.jdbcdriver.result.ResultExtractorImpl;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public class ExpectationsImpl implements Expectations {

    private final @NotNull List<@NotNull Expectation> expectations;
    private final @NotNull List<@NotNull ClassAndMethod> classAndMethodsThatRequireExpectation;
    private final @NotNull ExpectationsType expectationsType;
    private int currentExpectationIndex;

    public ExpectationsImpl(
            final @NotNull List<@NotNull Expectation> newExpectations,
            final @NotNull List<@NotNull ClassAndMethod> newClassAndMethodsThatRequireExpectation,
            final @NotNull ExpectationsType newExpectationsType
    ) {

        expectations = new ArrayList<>(newExpectations);
        classAndMethodsThatRequireExpectation = new ArrayList<>(newClassAndMethodsThatRequireExpectation);
        expectationsType = newExpectationsType;
    }

    @Override
    public void match(final @NotNull String className, final @NotNull String instanceName, final @NotNull String methodName) {
        match(className, instanceName, methodName, Collections.emptyList());
    }

    @Override
    public void match(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.empty());
    }

    @Override
    public @NotNull Optional<Mock> matchAndReturnMockResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull String resultMockClassName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(resultMockClassName))
        ).getMock();
    }

    public @NotNull Optional<Mock> matchAndReturnMockResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters,
            final @NotNull String resultClassName
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(resultClassName))).getMock();
    }

    @Override
    public @NotNull Optional<String> matchAndReturnStringResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName)
    {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.STRING.toString()))
        ).extractString();
    }

    @Override
    public @NotNull Optional<String> matchAndReturnStringResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.STRING.toString())))
                .extractString();
    }

    @Override
    public @NotNull Optional<Boolean> matchAndReturnBooleanResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(
                className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.BOOLEAN.toString()))
        ).extractBoolean();
    }

    @Override
    public @NotNull Optional<Boolean> matchAndReturnBooleanResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.BOOLEAN.toString())))
                .extractBoolean();
    }

    @Override
    public @NotNull Optional<Integer> matchAndReturnIntegerResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.INTEGER.toString()))
        ).extractInteger();
    }

    @Override
    public @NotNull Optional<Integer> matchAndReturnIntegerResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.INTEGER.toString())))
                .extractInteger();
    }

    @Override
    public @NotNull Optional<BigDecimal> matchAndReturnBigDecimalResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.BIG_DECIMAL.toString()))
        ).extractBigDecimal();
    }

    @Override
    public @NotNull Optional<BigDecimal> matchAndReturnBigDecimalResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.BIG_DECIMAL.toString())))
                .extractBigDecimal();
    }

    @Override
    public @NotNull Optional<byte[]> matchAndReturnByteArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.BYTE_ARRAY.toString()))
        ).extractByteArray();
    }

    @Override
    public @NotNull Optional<byte[]> matchAndReturnByteArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.BYTE_ARRAY.toString())))
                .extractByteArray();
    }

    @Override
    public @NotNull Optional<Date> matchAndReturnDateResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.DATE.toString()))
        ).extractDate();
    }

    @Override
    public @NotNull Optional<Date> matchAndReturnDateResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.DATE.toString())))
                .extractDate();
    }

    @Override
    public @NotNull Optional<Double> matchAndReturnDoubleResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.DOUBLE.toString()))
        ).extractDouble();
    }

    @Override
    public @NotNull Optional<Double> matchAndReturnDoubleResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.DOUBLE.toString())))
                .extractDouble();
    }

    @Override
    public @NotNull Optional<Float> matchAndReturnFloatResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.FLOAT.toString()))
        ).extractFloat();
    }

    @Override
    public @NotNull Optional<Float> matchAndReturnFloatResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.FLOAT.toString())))
                .extractFloat();
    }

    @Override
    public @NotNull Optional<int[]> matchAndReturnIntegerArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.INTEGER_ARRAY.toString()))
        ).extractIntegerArray();
    }

    @Override
    public @NotNull Optional<int[]> matchAndReturnIntegerArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.INTEGER_ARRAY.toString())))
                .extractIntegerArray();
    }

    @Override
    public @NotNull Optional<Long> matchAndReturnLongResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.LONG.toString()))
        ).extractLong();
    }

    @Override
    public @NotNull Optional<Long> matchAndReturnLongResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.LONG.toString())))
                .extractLong();
    }

    @Override
    public @NotNull Optional<String[]> matchAndReturnStringArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.STRING_ARRAY.toString()))
        ).extractStringArray();
    }

    @Override
    public @NotNull Optional<String[]> matchAndReturnStringArrayResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.STRING_ARRAY.toString())))
                .extractStringArray();
    }

    @Override
    public @NotNull Optional<Timestamp> matchAndReturnTimestampResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.TIMESTAMP.toString()))
        ).extractTimestamp();
    }

    @Override
    public @NotNull Optional<Timestamp> matchAndReturnTimestampResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.TIMESTAMP.toString())))
                .extractTimestamp();
    }

    @Override
    public @NotNull Optional<Time> matchAndReturnTimeResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.TIME.toString()))
        ).extractTime();
    }

    @Override
    public @NotNull Optional<Time> matchAndReturnTimeResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.TIME.toString())))
                .extractTime();
    }

    @Override
    public @NotNull Optional<Byte> matchAndReturnByteResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.BYTE.toString()))
        ).extractByte();
    }

    @Override
    public @NotNull Optional<Byte> matchAndReturnByteResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.BYTE.toString())))
                .extractByte();
    }

    @Override
    public @NotNull Optional<Short> matchAndReturnShortResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName
    ) {
        return new ResultExtractorImpl(
                matchAndReturnResult(className, instanceName, methodName, Collections.emptyList(), Optional.of(ValueType.SHORT.toString()))
        ).extractShort();
    }

    @Override
    public @NotNull Optional<Short> matchAndReturnShortResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters
    ) {
        return new ResultExtractorImpl(matchAndReturnResult(className, instanceName, methodName, methodParameters, Optional.of(ValueType.SHORT.toString())))
                .extractShort();
    }

    private @NotNull Value matchAndReturnResult(
            final @NotNull String className,
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters,
            final @NotNull Optional<String> resultClassName
    ) {
        if (!requiresExpectations(className, methodName)) {
            return VoidValue.instance;
        }

        if (expectationsType == ExpectationsType.IN_SEQUENCE) {
            return matchAndReturnResultForInSequenceExpectation(instanceName, methodName, methodParameters, resultClassName);
        } else if (expectationsType == ExpectationsType.ANY_ORDER) {
            return matchAndReturnResultForAnyOrderExpectation(instanceName, methodName, methodParameters, resultClassName);
        } else {
            throw new IllegalStateException("Invalid expectations type");
        }
    }

    private boolean requiresExpectations(final @NotNull String className, final @NotNull String methodName) {
        return classAndMethodsThatRequireExpectation.stream()
                .anyMatch(classAndMethod -> classAndMethod.getClassName().equals(className) && classAndMethod.getMethodName().equals(methodName));
    }

    private @NotNull Value matchAndReturnResultForInSequenceExpectation(
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters,
            final @NotNull Optional<String> resultClassName
    ) {
        if (currentExpectationIndex >= expectations.size()) {
            throw new MockDbException(MockDbExceptionType.MISSING_EXPECTATION);
        }

        currentExpectationIndex++;
        return expectations.get(currentExpectationIndex).matchAndReturnResult(instanceName, methodName, methodParameters, resultClassName);
    }

    private @NotNull Value matchAndReturnResultForAnyOrderExpectation(
            final @NotNull String instanceName,
            final @NotNull String methodName,
            final @NotNull List<@NotNull Value> methodParameters,
            final @NotNull Optional<String> resultClassName
    ) {
        return expectations.stream().filter(expectation -> {
            try {
                expectation.matchAndReturnResult(instanceName, methodName, methodParameters, resultClassName);
                return true;
            } catch (final MockDbException exception) {
                return false;
            }
        }).findFirst()
                .map(expectation -> expectation.matchAndReturnResult(instanceName, methodName, methodParameters, resultClassName))
                .orElse(VoidValue.instance);
    }
}
