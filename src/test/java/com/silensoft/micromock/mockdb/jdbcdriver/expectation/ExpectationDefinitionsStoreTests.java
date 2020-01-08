package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import mockit.*;
import mockit.Expectations;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

@SuppressWarnings({"InstanceVariableOfConcreteClass", "DoubleBraceInitialization"})
public class ExpectationDefinitionsStoreTests {

    private static final String CONNECTION_URL = "jdbc:h2:~/testdb";
    private static final String EXPECTATION_DEFINITION_1 = "Expectation definition 1";
    private static final String EXPECTATION_DEFINITION_2 = "Expectation definition 2";

    @Tested
    private @NotNull ExpectationDefinitionsStoreImpl expectationDefinitionsStore;

    @Mocked
    private @NotNull Connection connectionMock;

    @Mocked
    private @NotNull Statement statementMock;

    @Mocked
    private @NotNull ResultSet resultSetMock;

    @Test
    void testReadExpectationDefinitions() {
        new MockUp<DriverManager>() {
            @Mock
            Connection getConnection(final @NotNull String connectionUrl, final String userName, final String password) throws SQLException {
                if (connectionUrl.equals(CONNECTION_URL)) {
                    return connectionMock;
                }
                throw new SQLException();
            }
        };

        try {
            new Expectations() {{
                connectionMock.createStatement(); result = statementMock;
                statementMock.executeQuery(ExpectationDefinitionsStoreImpl.READ_EXPECTATIONS); result = resultSetMock;
                resultSetMock.next(); returns(true, true, false);
                resultSetMock.getString(2); returns(EXPECTATION_DEFINITION_1, EXPECTATION_DEFINITION_2);
            }};

           final @NotNull List<@NotNull String> expectationDefinitions = expectationDefinitionsStore.readExpectationDefinitions("");

            new Verifications() {{
                assertEquals(expectationDefinitions.size(), 2);
                assertEquals(expectationDefinitions.get(0), EXPECTATION_DEFINITION_1);
                assertEquals(expectationDefinitions.get(1), EXPECTATION_DEFINITION_2);
            }};

        } catch (final Exception exception) {
            fail("Expected successful read of expectation definitions, but exception was thrown");
        }
    }

    @Test
    void testReadExpectationDefinitionsWhenConnectionFails() {
        new MockUp<DriverManager>() {
            @Mock
            Connection getConnection(final @NotNull String connectionUrl, final String userName, final String password) throws SQLException {
                throw new SQLException();
            }
        };

        try {
            final @NotNull List<@NotNull String> expectationDefinitions = expectationDefinitionsStore.readExpectationDefinitions("");
        } catch (final MockDbException exception) {
            assertEquals(exception.getMessage(), MockDbExceptionType.MOCK_DB_READ_DEFINITIONS_ERROR.toString());
        } catch (final Exception exception) {
            fail("MockDbException was expected to be thrown, but different exception was thrown");
        }
    }
}
