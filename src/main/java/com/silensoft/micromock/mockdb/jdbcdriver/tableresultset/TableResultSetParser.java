package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import org.jetbrains.annotations.NotNull;

public interface TableResultSetParser {
    @NotNull TableResultSet parseTableResultSet(final @NotNull String table);
}
