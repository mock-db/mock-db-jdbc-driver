package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.tableresultset.TableResultSet;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class TableResultMockImpl implements Mock {
    private final @NotNull TableResultSet tableResultSet;

    public TableResultMockImpl(final @NotNull TableResultSet newTableResultSet) {
        tableResultSet = newTableResultSet;
    }

    @Override
    public @NotNull String getClassName() {
        return "ResultSet";
    }

    @Override
    public @NotNull String getName() {
        return "No name";
    }

    @Override
    public @NotNull Optional<TableResultSet> getTableResultSet() {
        return Optional.of(tableResultSet);
    }
}
