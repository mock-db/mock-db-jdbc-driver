package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.StringValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import java.util.Optional;

public class MockDbSavepoint implements Savepoint {
    private static final String SAVEPOINT = "Savepoint";

    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optSavepointMock;

    public MockDbSavepoint(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newSavepointMock) {
        expectations = newExpectations;
        optSavepointMock = newSavepointMock;
    }

    @Override
    public int getSavepointId() throws SQLException {
        return optSavepointMock
                .flatMap(savepointMock -> expectations.matchAndReturnIntegerResult(SAVEPOINT, savepointMock.getName(), "getSavepointId"))
                .orElse(0);
    }

    @Override
    public @Nullable String getSavepointName() throws SQLException {
        return optSavepointMock
                .flatMap(savepointMock -> expectations.matchAndReturnStringResult(SAVEPOINT, savepointMock.getName(), "getSavepointName"))
                .orElse(null);
    }
}
