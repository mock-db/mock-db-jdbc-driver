package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationFactory;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcher;
import com.silensoft.micromock.mockdb.jdbcdriver.value.Value;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

@SuppressWarnings({"DoubleBraceInitialization", "InstanceVariableOfConcreteClass"})
public class ExpectationTests {

    private static final String INSTANCE_NAME = "instance";
    private static final String METHOD_NAME = "method";
    private static final Optional<String> OPT_CLASS_NAME = Optional.of("Class");
    private static final String CLASS_NAME = "Class";

    @Injectable
    @Mocked
    private @NotNull MethodInvocationMatcher methodInvocationMatcherMock;

    @Injectable
    @Mocked
    private @NotNull Value resultMock;

    @Injectable
    @Mocked
    private @NotNull MethodInvocationFactory methodInvocationFactoryMock;

    @SuppressWarnings("FieldMayBeStatic")
    @Injectable
    private final int methodCallCount = 1;

    @Tested
    private  @NotNull ExpectationImpl expectation;

    @Mocked
    private @NotNull List<@NotNull Value> mockedMethodParameters;

    @Mocked
    private @NotNull MethodInvocationImpl methodInvocationMock;

    @Test
    void testMatchAndReturnResult() {

        new Expectations() {{
            methodInvocationFactoryMock.createMethodInvocation(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters); result = methodInvocationMock;
            methodInvocationMatcherMock.matches(methodInvocationMock); result = true;
            resultMock.getClassName(); result = OPT_CLASS_NAME;

        }};

        final @NotNull Value result = expectation.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, OPT_CLASS_NAME);

        new Verifications() {{
            assertEquals(result, resultMock);
        }};
    }

    @Test
    void testMatchAndReturnResultOnMethodInvocationMismatch() {

        new Expectations() {{
            methodInvocationFactoryMock.createMethodInvocation(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters); result = methodInvocationMock;
            methodInvocationMatcherMock.matches(methodInvocationMock); result = false;
        }};

        final @NotNull Value result;
        try {
            result = expectation.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, OPT_CLASS_NAME);
            fail("MockDbException was expected to be thrown, but it was not thrown");
        } catch (final MockDbException exception) {
            assertEquals(exception.getMessage(), MockDbExceptionType.EXPECTATION_MISMATCH.toString());
        } catch (final Exception exception) {
            fail("MockDbException was expected to be thrown, but different exception was thrown");
        }
    }

    @Test
    void testMatchAndReturnResultOnResultClassMismatch() {

        new Expectations() {{
            methodInvocationFactoryMock.createMethodInvocation(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters); result = methodInvocationMock;
            methodInvocationMatcherMock.matches(methodInvocationMock); result = true;
            resultMock.getClassName(); result = OPT_CLASS_NAME;
        }};

        final @NotNull Value result;
        try {
            result = expectation.matchAndReturnResult(INSTANCE_NAME, METHOD_NAME, mockedMethodParameters, Optional.of("Class2"));
            fail("MockDbException was expected to be thrown, but it was not thrown");
        } catch (final MockDbException exception) {
            assertEquals(exception.getMessage(), MockDbExceptionType.EXPECTATION_MISMATCH.toString());
        } catch (final Exception exception) {
            fail("MockDbException was expected to be thrown, but different exception was thrown");
        }
    }

    @Test
    void testGetInvocationClassName() {

        new Expectations() {{
            methodInvocationMatcherMock.getClassName(); result = CLASS_NAME;
        }};

        final @NotNull String className = expectation.getInvocationClassName();

        new Verifications() {{
            assertEquals(className, CLASS_NAME);
        }};
    }

    @Test
    void testGetInvocationMethodName() {

        new Expectations() {{
            methodInvocationMatcherMock.getMethodName(); result = METHOD_NAME;
        }};

        final @NotNull String methodName = expectation.getInvocationMethodName();

        new Verifications() {{
            assertEquals(methodName, METHOD_NAME);
        }};
    }
}
