package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.*;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@SuppressWarnings("DoubleBraceInitialization")
public class ExpectationsTests {

    private static final String CLASS_NAME = "Class";
    private static final String INSTANCE_NAME = "instance";
    private static final String METHOD_NAME = "method";
    private static final String MOCK_CLASS_NAME = "mockClass";

    @Mocked
    private @NotNull Expectation expectationMock;

    @Mocked
    private @NotNull ClassAndMethod classAndMethodMock;

    @Mocked
    private @NotNull Value valueMock;

    @Test
    void testMatch_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.empty());
            result = new IntegerValue(1);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .match(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);
    }

    @Test
    void testMatch_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.empty());
            result = new IntegerValue(1);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .match(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);
    }

    @Test
    void testMatchAndReturnMockResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(MOCK_CLASS_NAME));
            result = new MockValue(MOCK_CLASS_NAME);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Mock> possibleMock = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnMockResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, MOCK_CLASS_NAME);

        new Verifications() {{
            assertTrue(possibleMock.isPresent());
            assertEquals(possibleMock.get().getClassName(), MOCK_CLASS_NAME);
        }};
    }

    @Test
    void testMatchAndReturnMockResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(MOCK_CLASS_NAME));
            result = new MockValue(MOCK_CLASS_NAME);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Mock> possibleMock = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnMockResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, MOCK_CLASS_NAME);

        new Verifications() {{
            assertTrue(possibleMock.isPresent());
            assertEquals(possibleMock.get().getClassName(), MOCK_CLASS_NAME);
        }};
    }

    @Test
    void testMatchAndReturnStringResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(ValueType.STRING.toString()));
            result = new StringValue("stringValue");
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<String> possibleString = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnStringResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);

        new Verifications() {{
            assertTrue(possibleString.isPresent());
            assertEquals(possibleString.get(), "stringValue");
        }};
    }

    @Test
    void testMatchAndReturnStringResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(ValueType.STRING.toString()));
            result = new StringValue("stringValue");
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<String> possibleString = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnStringResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);

        new Verifications() {{
            assertTrue(possibleString.isPresent());
            assertEquals(possibleString.get(), "stringValue");
        }};
    }

    @Test
    void testMatchAndReturnBooleanResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(ValueType.BOOLEAN.toString()));
            result = new BooleanValue(true);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Boolean> possibleBoolean = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnBooleanResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);

        new Verifications() {{
            assertTrue(possibleBoolean.isPresent());
            assertTrue(possibleBoolean.get());
        }};
    }

    @Test
    void testMatchAndReturnBooleanResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(ValueType.BOOLEAN.toString()));
            result = new BooleanValue(true);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Boolean> possibleBoolean = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnBooleanResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);

        new Verifications() {{
            assertTrue(possibleBoolean.isPresent());
            assertTrue(possibleBoolean.get());
        }};
    }

    @Test
    void testMatchAndReturnIntegerResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(ValueType.INTEGER.toString()));
            result = new IntegerValue(1);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Integer> possibleInteger = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnIntegerResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);

        new Verifications() {{
            assertTrue(possibleInteger.isPresent());
            assertEquals(possibleInteger.get().intValue(), 1);
        }};
    }

    @Test
    void testMatchAndReturnIntegerResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(ValueType.INTEGER.toString()));
            result = new IntegerValue(1);
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<Integer> possibleInteger = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnIntegerResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);

        new Verifications() {{
            assertTrue(possibleInteger.isPresent());
            assertEquals(possibleInteger.get().intValue(), 1);
        }};
    }

    @Test
    void testMatchAndReturnBigDecimalResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(ValueType.BIG_DECIMAL.toString()));
            result = new BigDecimalValue(new BigDecimal(1));
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<BigDecimal> possibleBigDecimal = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnBigDecimalResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);

        new Verifications() {{
            assertTrue(possibleBigDecimal.isPresent());
            assertEquals(possibleBigDecimal.get().compareTo(new BigDecimal(1)), 0);
        }};
    }

    @Test
    void testMatchAndReturnBigDecimalResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(ValueType.BIG_DECIMAL.toString()));
            result = new BigDecimalValue(new BigDecimal(1));
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        final @NotNull Optional<BigDecimal> possibleBigDecimal = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnBigDecimalResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);

        new Verifications() {{
            assertTrue(possibleBigDecimal.isPresent());
            assertEquals(possibleBigDecimal.get().compareTo(new BigDecimal(1)), 0);
        }};
    }

    @Test
    void testMatchAndReturnByteArrayResult_withoutMethodParameters() {
        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, Collections.emptyList(), Optional.of(ValueType.BYTE_ARRAY.toString()));
            result = new ByteArrayValue(new byte[]{(byte) 1, (byte) 2});
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        //noinspection OptionalContainsCollection
        final @NotNull Optional<byte[]> possibleByteArray = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnByteArrayResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME);

        new Verifications() {{
            assertTrue(possibleByteArray.isPresent());
            assertEquals(possibleByteArray.get().length, 2);
            assertEquals(possibleByteArray.get()[0], (byte) 1);
            assertEquals(possibleByteArray.get()[1], (byte) 2);
        }};
    }

    @Test
    void testMatchAndReturnByteArrayResult_withMethodParameters() {
        final @NotNull List<@NotNull Value> mockedMethodParameters = List.of(valueMock);

        new Expectations() {{
            classAndMethodMock.getClassName();
            result = CLASS_NAME;
            classAndMethodMock.getMethodName();
            result = METHOD_NAME;
            expectationMock.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of(ValueType.BYTE_ARRAY.toString()));
            result = new ByteArrayValue(new byte[]{(byte) 1, (byte) 2});
        }};

        final @NotNull List<@NotNull Expectation> mockedExpectations = List.of(expectationMock);
        final @NotNull List<@NotNull ClassAndMethod> mockedClassAndMethodsThatRequireExpectation = List.of(classAndMethodMock);
        //noinspection OptionalContainsCollection
        final @NotNull Optional<byte[]> possibleByteArray = new ExpectationsImpl(mockedExpectations, mockedClassAndMethodsThatRequireExpectation, ExpectationsType.ANY_ORDER)
                .matchAndReturnByteArrayResult(CLASS_NAME, INSTANCE_NAME, METHOD_NAME, mockedMethodParameters);

        new Verifications() {{
            assertTrue(possibleByteArray.isPresent());
            assertEquals(possibleByteArray.get().length, 2);
            assertEquals(possibleByteArray.get()[0], (byte) 1);
            assertEquals(possibleByteArray.get()[1], (byte) 2);
        }};
    }
}
