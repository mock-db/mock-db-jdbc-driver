package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbParseException;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.InvocationCountParser;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcherParser;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.result.ResultParser;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class ExpectationParserImpl implements ExpectationParser {
    private static final Logger logger = Logger.getLogger("ExpectationParser");

    @Inject
    private @NotNull MethodInvocationMatcherParser methodInvocationMatcherParser;

    @Inject
    private @NotNull InvocationCountParser invocationCountParser;

    @Inject
    private @NotNull ResultParser resultParser;

    @Inject
    private @NotNull ExpectationFactory expectationFactory;

    @Override
    public @NotNull Expectation parseExpectation(final @NotNull String expectationDefinition, final @NotNull Mocks mocks) {
        final @NotNull List<@NotNull String> expectationDefinitionParts = splitToParts(expectationDefinition);

        if (expectationDefinitionParts.size() == 2) {
            final @NotNull String methodInvocationStatement =
                    expectationDefinitionParts.get(0).substring(0, expectationDefinitionParts.get(0).length() - 1).trim();
            final @NotNull String resultStatement = expectationDefinitionParts.get(1).substring(0, expectationDefinitionParts.get(1).length() - 1).trim();
            return parseExpectation(methodInvocationStatement, Optional.empty(), resultStatement, mocks);
        } else if (expectationDefinitionParts.size() == 3) {
            final @NotNull String methodInvocationStatement =
                    expectationDefinitionParts.get(0).substring(0, expectationDefinitionParts.get(0).length() - 1).trim();
            final @NotNull String invocationCountStatement =
                    expectationDefinitionParts.get(1).substring(0, expectationDefinitionParts.get(1).length() - 1).trim();
            final @NotNull String resultStatement = expectationDefinitionParts.get(2).substring(0, expectationDefinitionParts.get(2).length() - 1).trim();
            return parseExpectation(methodInvocationStatement, Optional.of(invocationCountStatement), resultStatement, mocks);
        } else {
            throw new MockDbParseException("Failed to parse expectation definition: " + expectationDefinition);
        }
    }

    private static @NotNull List<@NotNull String> splitToParts(final @NotNull String expectationDefinition) {
        final @NotNull List<@NotNull String> expectationDefinitionParts = new ArrayList<>(4);

        //noinspection UseOfStringTokenizer
        final @NotNull StringTokenizer stringTokenizer = new StringTokenizer(expectationDefinition, "\";", true);
        final @NotNull StringBuilder currentPartStringBuilder = new StringBuilder(512);
        boolean isOutOfStringLiteral = true;

        while (stringTokenizer.hasMoreTokens()) {
            @NotNull String delim = "";
            final @NotNull String token = Objects.requireNonNull(stringTokenizer.nextToken());

            if (stringTokenizer.hasMoreTokens()) {
                delim = Objects.requireNonNull(stringTokenizer.nextToken());
            }

            currentPartStringBuilder.append(token);
            currentPartStringBuilder.append(delim);

            if ("\"".equals(delim) && !token.endsWith("\\")) {
                isOutOfStringLiteral = !isOutOfStringLiteral;
            } else if ((";".equals(delim) || delim.isEmpty() && ";".equals(token)) && isOutOfStringLiteral) {
                expectationDefinitionParts.add(currentPartStringBuilder.toString());
                currentPartStringBuilder.delete(0, currentPartStringBuilder.length());
            }
        }

        return expectationDefinitionParts;
    }

    private @NotNull Expectation parseExpectation(
            final @NotNull String methodInvocationStatement,
            final @NotNull Optional<String> optInvocationCountStatement,
            final @NotNull String resultStatement,
            final @NotNull Mocks mocks
    ) {

        final @NotNull MethodInvocationMatcher methodInvocationMatcher =
                methodInvocationMatcherParser.parseMethodInvocationMatcher(methodInvocationStatement, mocks);
        final int invocationCount = optInvocationCountStatement
                .map(invocationCountStatement -> invocationCountParser.parseInvocationCount(invocationCountStatement))
                .orElse(1);
        final @NotNull Value result = resultParser.parseResult(resultStatement, mocks);
        return expectationFactory.createExpectation(methodInvocationMatcher, invocationCount, result);
    }
}
