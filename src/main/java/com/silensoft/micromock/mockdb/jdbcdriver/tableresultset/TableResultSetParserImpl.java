package com.silensoft.micromock.mockdb.jdbcdriver.tableresultset;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class TableResultSetParserImpl implements TableResultSetParser {

    private static final String COLUMN_SEPARATOR = "[^\\\\]\\|";

    @Override
    public @NotNull TableResultSet parseTableResultSet(final @NotNull String table) {
        final String lineSeparator = System.getProperty("line.separator");
        final String[] tableRows = table.split(Objects.requireNonNull(lineSeparator));

        if (tableRows.length < 2) {
            return new TableResultSetImpl(Collections.emptyList(), Collections.emptyList());
        }

        final List<@NotNull String> columnNames = Arrays.stream(tableRows[0].split(COLUMN_SEPARATOR))
                .filter(columnName -> !columnName.isEmpty())
                .map(String::trim)
                .map(columnName -> columnName.replace("\\|", "|"))
                .collect(Collectors.toList());

        final List<@NotNull Row> rows = Arrays.stream(tableRows)
                .skip(1L)
                .map(tableRow -> Arrays.stream(tableRow
                        .split(COLUMN_SEPARATOR))
                        .filter(cell -> !cell.isEmpty())
                        .map(String::trim)
                        .map(cell -> cell.replace("\\|", "|"))
                        .collect(Collectors.toList()))
                .map(RowImpl::new)
                .collect(Collectors.toList());

        return new TableResultSetImpl(columnNames, rows);
    }
}
