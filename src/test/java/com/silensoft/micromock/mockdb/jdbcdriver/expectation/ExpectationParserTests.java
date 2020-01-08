package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.InvocationCountParser;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcherParser;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import com.silensoft.micromock.mockdb.jdbcdriver.result.ResultParser;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SuppressWarnings({"InstanceVariableOfConcreteClass", "DoubleBraceInitialization"})
public class ExpectationParserTests {

    private static final String EXPECTATION_DEFINITION = "adder.add(1, 2); result = 3;";
    private static final String METHOD_INVOCATION_STATEMENT = "adder.add(1, 2)";
    private static final String RESULT_STATEMENT = "result = 3";

    private static final String EXPECTATION_DEFINITION_2 = "adder.add(\"test\", \"1\"); result = \"test1\";";
    private static final String METHOD_INVOCATION_STATEMENT_2 = "adder.add(\"test\", \"1\")";
    private static final String RESULT_STATEMENT_2 = "result = \"test1\"";

    private static final String EXPECTATION_DEFINITION_3 = "adder.add(\"te\\\"st;\", \"1\\\"\"); result = \";test1;\";";
    private static final String METHOD_INVOCATION_STATEMENT_3 = "adder.add(\"te\\\"st;\", \"1\\\"\")";
    private static final String RESULT_STATEMENT_3 = "result = \";test1;\"";

    private static final String EXPECTATION_DEFINITION_4 = "adder.add(1, 2); times = 2; result = 3;";
    private static final String METHOD_INVOCATION_STATEMENT_4 = "adder.add(1, 2)";
    private static final String METHOD_INVOCATION_COUNT_STATEMENT_4 = "times = 2";
    private static final String RESULT_STATEMENT_4 = "result = 3";

    @Tested
    private @NotNull ExpectationParserImpl expectationParser;

    @Injectable
    @Mocked
    private @NotNull MethodInvocationMatcherParser methodInvocationMatcherParserMock;

    @Injectable
    @Mocked
    private @NotNull InvocationCountParser invocationCountParserMock;

    @Injectable
    @Mocked
    private @NotNull ResultParser resultParserMock;

    @Injectable
    @Mocked @NotNull ExpectationFactory expectationFactoryMock;

    @Mocked
    private @NotNull Mocks mockedMocks;

    @Mocked
    private @NotNull MethodInvocationMatcher methodInvocationMatcherMock;

    @Mocked
    private @NotNull Value resultValueMock;

    @Mocked
    private @NotNull Expectation expectationMock;

    @Test
    void testParseExpectation() {
        new Expectations() {{
            methodInvocationMatcherParserMock.parseMethodInvocationMatcher(METHOD_INVOCATION_STATEMENT, mockedMocks); result = methodInvocationMatcherMock;
            resultParserMock.parseResult(RESULT_STATEMENT, mockedMocks); result = resultValueMock;
            expectationFactoryMock.createExpectation(methodInvocationMatcherMock, 1, resultValueMock); result = expectationMock;
        }};

        final @NotNull Expectation expectation = expectationParser.parseExpectation(EXPECTATION_DEFINITION, mockedMocks);

        new Verifications() {{
           assertEquals(expectation, expectationMock);
        }};
    }

    @Test
    void testParseExpectationWithStringLiterals() {
        new Expectations() {{
            methodInvocationMatcherParserMock.parseMethodInvocationMatcher(METHOD_INVOCATION_STATEMENT_2, mockedMocks); result = methodInvocationMatcherMock;
            resultParserMock.parseResult(RESULT_STATEMENT_2, mockedMocks); result = resultValueMock;
            expectationFactoryMock.createExpectation(methodInvocationMatcherMock, 1, resultValueMock); result = expectationMock;
        }};

        final @NotNull Expectation expectation = expectationParser.parseExpectation(EXPECTATION_DEFINITION_2, mockedMocks);

        new Verifications() {{
            assertEquals(expectation, expectationMock);
        }};
    }

    @Test
    void testParseExpectationWithStringLiteralsContainingQuotes() {
        new Expectations() {{
            methodInvocationMatcherParserMock.parseMethodInvocationMatcher(METHOD_INVOCATION_STATEMENT_3, mockedMocks); result = methodInvocationMatcherMock;
            resultParserMock.parseResult(RESULT_STATEMENT_3, mockedMocks); result = resultValueMock;
            expectationFactoryMock.createExpectation(methodInvocationMatcherMock, 1, resultValueMock); result = expectationMock;
        }};

        final @NotNull Expectation expectation = expectationParser.parseExpectation(EXPECTATION_DEFINITION_3, mockedMocks);

        new Verifications() {{
            assertEquals(expectation, expectationMock);
        }};
    }

    @Test
    void testParseExpectationWithInvocationCountSpecified() {
        new Expectations() {{
            methodInvocationMatcherParserMock.parseMethodInvocationMatcher(METHOD_INVOCATION_STATEMENT_4, mockedMocks); result = methodInvocationMatcherMock;
            invocationCountParserMock.parseInvocationCount(METHOD_INVOCATION_COUNT_STATEMENT_4); result = 2;
            resultParserMock.parseResult(RESULT_STATEMENT_4, mockedMocks); result = resultValueMock;
            expectationFactoryMock.createExpectation(methodInvocationMatcherMock, 2, resultValueMock); result = expectationMock;
        }};

        final @NotNull Expectation expectation = expectationParser.parseExpectation(EXPECTATION_DEFINITION_4, mockedMocks);

        new Verifications() {{
            assertEquals(expectation, expectationMock);
        }};
    }
}
