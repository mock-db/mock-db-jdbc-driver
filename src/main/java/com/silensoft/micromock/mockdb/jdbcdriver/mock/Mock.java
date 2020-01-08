package com.silensoft.micromock.mockdb.jdbcdriver.mock;

import com.silensoft.micromock.mockdb.jdbcdriver.tableresultset.TableResultSet;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface Mock {
    @NotNull String getClassName();
    @NotNull String getName();
    @NotNull Optional<TableResultSet> getTableResultSet();
}
