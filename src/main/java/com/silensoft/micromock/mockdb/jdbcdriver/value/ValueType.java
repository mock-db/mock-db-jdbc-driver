package com.silensoft.micromock.mockdb.jdbcdriver.value;

import org.jetbrains.annotations.NotNull;

public enum ValueType {
    STRING("String"),
    BOOLEAN("boolean"),
    INTEGER("int"),
    BIG_DECIMAL("BigDecimal"),
    BYTE_ARRAY("byte[]"),
    BYTE("byte"),
    DATE("Date"),
    DOUBLE("double"),
    FLOAT("float"),
    INTEGER_ARRAY("int[]"),
    LONG("long"),
    SHORT("short"),
    STRING_ARRAY("String[]"),
    TIMESTAMP("Timestamp"),
    TIME("Time");

    private final @NotNull String typeString;

    ValueType(final @NotNull String newTypeString) {
        typeString = newTypeString;
    }

    @Override
    public @NotNull String toString() {
        return typeString;
    }
}
