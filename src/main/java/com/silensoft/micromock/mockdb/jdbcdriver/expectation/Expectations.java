package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalContainsCollection")
public interface Expectations {
    void match(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    void match(@NotNull String className, @NotNull String instanceName, @NotNull String methodName, @NotNull List<@NotNull Value> methodParameters);

    @NotNull Optional<Mock> matchAndReturnMockResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull String resultMockClassName
    );
    @NotNull Optional<Mock> matchAndReturnMockResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters,
            @NotNull String resultMockClassName
    );

    @NotNull Optional<String> matchAndReturnStringResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<String> matchAndReturnStringResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Boolean> matchAndReturnBooleanResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Boolean> matchAndReturnBooleanResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Integer> matchAndReturnIntegerResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Integer> matchAndReturnIntegerResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<BigDecimal> matchAndReturnBigDecimalResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<BigDecimal> matchAndReturnBigDecimalResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<byte[]> matchAndReturnByteArrayResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<byte[]> matchAndReturnByteArrayResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Date> matchAndReturnDateResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Date> matchAndReturnDateResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Double> matchAndReturnDoubleResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Double> matchAndReturnDoubleResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Float> matchAndReturnFloatResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Float> matchAndReturnFloatResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<int[]> matchAndReturnIntegerArrayResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<int[]> matchAndReturnIntegerArrayResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Long> matchAndReturnLongResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Long> matchAndReturnLongResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<String[]> matchAndReturnStringArrayResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<String[]> matchAndReturnStringArrayResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Timestamp> matchAndReturnTimestampResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Timestamp> matchAndReturnTimestampResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Time> matchAndReturnTimeResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Time> matchAndReturnTimeResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Byte> matchAndReturnByteResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Byte> matchAndReturnByteResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );

    @NotNull Optional<Short> matchAndReturnShortResult(@NotNull String className, @NotNull String instanceName, @NotNull String methodName);
    @NotNull Optional<Short> matchAndReturnShortResult(
            @NotNull String className,
            @NotNull String instanceName,
            @NotNull String methodName,
            @NotNull List<@NotNull Value> methodParameters
    );
}
