package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValueMatchersParserImpl implements ValueMatchersParser {

    @Override
    public @NotNull List<@NotNull ValueMatcher> parseParameterMatchers(final @NotNull String parameterMatchersStatement, final @NotNull Mocks mocks) {
        // TODO: replace split with StringTokenizer to detect commas in string/regexp literals
        final @NotNull String[] parameterMatcherStatementParts = parameterMatchersStatement.split(",");
        return Arrays.stream(parameterMatcherStatementParts)
                .map(parameterMatcher -> new ValueParserImpl(mocks).parseParameterValue(parameterMatcher))
                .map(ValueMatcherImpl::new)
                .collect(Collectors.toList());
    }
}
