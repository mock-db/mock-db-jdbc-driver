package com.silensoft.micromock.mockdb.jdbcdriver.result;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbParseException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueParser;
import com.silensoft.micromock.mockdb.jdbcdriver.value.ValueParserImpl;
import org.jetbrains.annotations.NotNull;

public class ResultParserImpl implements ResultParser {
    private static final String RESULT = "result";

    @Override
    public @NotNull Value parseResult(final @NotNull String resultStatement, final @NotNull Mocks mocks) {
        final String[] resultExpressionParts = resultStatement.split("=");

        if (resultExpressionParts.length != 2) {
            throw new MockDbParseException(resultStatement);
        }

        if (!RESULT.equals(resultExpressionParts[0].trim())) {
            throw new MockDbParseException(resultStatement);
        }

        final String resultMockNameOrLiteral = resultExpressionParts[1].trim();
        return new ValueParserImpl(mocks).parseReturnValue(resultMockNameOrLiteral);

    }
}
