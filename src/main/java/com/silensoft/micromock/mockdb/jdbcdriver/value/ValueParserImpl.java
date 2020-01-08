package com.silensoft.micromock.mockdb.jdbcdriver.value;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbParseException;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.TableResultMockImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.tableresultset.TableResultSetParser;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;
import java.util.regex.Pattern;

public class ValueParserImpl implements ValueParser {

    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final String ANY = "any";
    private static final String BIG_DECIMAL_LITERAL_POSTFIX = "B";
    private static final String BYTE_ARRAY_LITERAL_PREFIX = "B\"";
    private static final String STRING_LITERAL_PREFIX = "\"";
    private static final String STRING_LITERAL_POSTFIX = "\"";
    private static final String REGEX_LITERAL_PREFIX = "/";
    private static final String REGEX_LITERAL_POSTFIX = "/";
    private static final String TABLE_RESULT_SET_LITERAL_PREFIX = "|";
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\\\.?[0-9]+([eE][-+]?[0-9]+)?");
    private static final Pattern FLOAT_PATTERN = Pattern.compile("[-+]?[0-9]*\\\\.?[0-9]+([eE][-+]?[0-9]+)?f");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("[-+]?\\d+");
    private static final Pattern LONG_PATTERN = Pattern.compile("[-+]?\\d+L");
    private static final Pattern TIME_PATTERN = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");
    private static final Pattern TIMESTAMP_PATTERN = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}\\w*\\d{2}:\\d{2}:\\d{2}[.\\d+]$");

    @Inject
    private @NotNull TableResultSetParser tableResultSetParser;

    private final @NotNull Mocks mocks;

    public ValueParserImpl(final @NotNull Mocks newMocks) {
        mocks = newMocks;
    }

    @Override
    public @NotNull Value parseReturnValue(final @NotNull String returnValue) {
        return parseValue(returnValue, EnumSet.of(ValueCategory.MOCK, ValueCategory.LITERAL));
    }

    @Override
    public @NotNull Value parseParameterValue(final @NotNull String parameterValue) {
        return parseValue(parameterValue, EnumSet.allOf(ValueCategory.class));
    }

    @SuppressWarnings({"OverlyComplexMethod", "OverlyLongMethod"})
    private @NotNull Value parseValue(final @NotNull String value, final @NotNull Collection<ValueCategory> allowedValueCategories) {
        final @NotNull Optional<Mock> mock = mocks.findMockByName(value);

        try {
            //noinspection IfStatementWithTooManyBranches
            if (value.isEmpty()) {
                return VoidValue.instance;
            } else if (value.endsWith(BIG_DECIMAL_LITERAL_POSTFIX)) {
                return new BigDecimalValue(new BigDecimal(value.substring(0, value.length() - 1)));
            } else if (TRUE.equals(value)) {
                return new BooleanValue(true);
            } else if (FALSE.equals(value)) {
                return new BooleanValue(false);
            } else if (value.startsWith(BYTE_ARRAY_LITERAL_PREFIX) && value.length() > 3) {
                final String hexDump = value.substring(2, value.length() - 1);
                return new ByteArrayValue(Hex.decodeHex(hexDump.toCharArray()));
            } else if (DATE_PATTERN.matcher(value).matches()) {
                return new DateValue(Date.valueOf(value));
            } else if (DOUBLE_PATTERN.matcher(value).matches()) {
                return new DoubleValue(Double.parseDouble(value));
            } else if (FLOAT_PATTERN.matcher(value).matches()) {
                return new FloatValue(Float.parseFloat(value));
            } else if (INTEGER_PATTERN.matcher(value).matches()) {
                return new IntegerValue(Integer.parseInt(value));
            } else if (LONG_PATTERN.matcher(value).matches()) {
                return new LongValue(Long.parseLong(value));
            } else if (mock.isPresent()) {
                return new MockValue(mock.get());
            } else if (value.startsWith(STRING_LITERAL_PREFIX) && value.endsWith(STRING_LITERAL_POSTFIX) && value.length() >=2) {
                return new StringValue(value.substring(1, value.length() - 1));
            } else if (TIME_PATTERN.matcher(value).matches()) {
                return new TimeValue(Time.valueOf(value));
            } else if (TIMESTAMP_PATTERN.matcher(value).matches()) {
                return new TimestampValue(Timestamp.valueOf(value));
            } else if (value.startsWith(TABLE_RESULT_SET_LITERAL_PREFIX)) {
                return new MockValue(new TableResultMockImpl(tableResultSetParser.parseTableResultSet(value)));
            } else if (allowedValueCategories.contains(ValueCategory.REGEX) && value.startsWith(REGEX_LITERAL_PREFIX) && value.endsWith(REGEX_LITERAL_POSTFIX) && value.length() >=2) {
                return new RegexValue(value.substring(1, value.length() - 1));
            } else if (allowedValueCategories.contains(ValueCategory.ANY) && ANY.equals(value)) {
                return new AnyValue();
            } else {
                throw new MockDbParseException("Unrecognized expectation result type or missing mock definition: " + value);
            }
        } catch (final RuntimeException | DecoderException exception) {
            throw new MockDbParseException("Failed to parse expectation result literal: " + value);
        }
    }
}
