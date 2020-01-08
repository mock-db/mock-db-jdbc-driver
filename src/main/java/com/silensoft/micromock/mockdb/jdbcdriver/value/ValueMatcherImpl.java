package com.silensoft.micromock.mockdb.jdbcdriver.value;

import org.jetbrains.annotations.NotNull;

public class ValueMatcherImpl implements ValueMatcher {

    private final @NotNull Value value;

    public ValueMatcherImpl(final @NotNull Value newValue) {
        value = newValue;
    }

    @Override
    public boolean matches(final @NotNull Value otherValue) {
        return value.equals(otherValue);
    }
}
