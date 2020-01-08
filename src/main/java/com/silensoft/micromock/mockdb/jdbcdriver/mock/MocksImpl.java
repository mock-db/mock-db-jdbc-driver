package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MocksImpl implements Mocks {
    private final List<@NotNull Mock> mocks;

    public MocksImpl(final @NotNull List<@NotNull Mock> newMocks) {
        mocks = new ArrayList<>(newMocks);
    }

    @Override
    public @NotNull Optional<Mock> findMockByName(@NotNull String name) {
        return Optional.empty();
    }
}
