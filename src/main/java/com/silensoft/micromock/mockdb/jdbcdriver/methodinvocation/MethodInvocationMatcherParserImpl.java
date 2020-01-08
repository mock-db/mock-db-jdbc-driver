package com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbParseException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueMatchersParser;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class MethodInvocationMatcherParserImpl implements MethodInvocationMatcherParser {

    @Inject
    private @NotNull ValueMatchersParser valueMatchersParser;

    @Override
    public @NotNull MethodInvocationMatcher parseMethodInvocationMatcher(
            final @NotNull String methodInvocationStatement,
            final @NotNull Mocks mocks
    ) throws MockDbParseException {

        final @NotNull String[] methodInvocationParts = methodInvocationStatement.split("(.+\\.)(.+\\()(.*\\))");

        if (methodInvocationParts.length != 3) {
            throw new MockDbParseException("Failed to parse expected method invocation: " + methodInvocationStatement);
        }

        final @NotNull String instanceName = methodInvocationParts[0];
        final @NotNull Optional<Mock> optMock = mocks.findMockByName(instanceName);
        final @NotNull String methodName = methodInvocationParts[1];
        final @NotNull String methodParameterMatchersStatement = methodInvocationParts[2];
        final @NotNull List<@NotNull ValueMatcher> methodValueMatchers = valueMatchersParser.parseParameterMatchers(methodParameterMatchersStatement, mocks);

        return optMock
                .map(mock -> new MethodInvocationMatcherImpl(mock.getClassName(), instanceName, methodName, methodValueMatchers))
                .orElseThrow(() -> new MockDbParseException("Failed to parse expected method invocation, no mock found instance name" + methodInvocationStatement));
    }
}
