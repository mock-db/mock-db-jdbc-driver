package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.tableresultset.TableResultSet;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class MockImpl implements Mock {
    private final @NotNull String className;
    private final @NotNull String name;

    public MockImpl(final @NotNull String newClassName, final @NotNull String newName) {
        className = newClassName;
        name = newName;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Mock) {
            final Mock otherMock = (Mock) object;
            return name.isEmpty() ? className.equals(otherMock.getClassName()) : className.equals(otherMock.getClassName()) && name.equals(otherMock.getName());
        }

        return false;
    }

    @Override
    public @NotNull String getClassName() {
        return className;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull Optional<TableResultSet> getTableResultSet() {
        return Optional.empty();
    }
}
