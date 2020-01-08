package com.silensoft.micromock.mockdb.jdbcdriver.expectation;

import com.google.inject.Inject;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mocks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ExpectationsFactoryImpl implements ExpectationsFactory {

    @Inject
    private @NotNull ExpectationParser expectationParser;

    @Override
    public @NotNull Expectations createExpectations(
            final @NotNull Collection<@NotNull String> expectationDefinitions,
            final @NotNull ExpectationsType expectationsType,
            final @NotNull Mocks mocks
    ) {

        final List<@NotNull ClassAndMethod> classAndMethodsThatRequireExpectation = new ArrayList<>(25);

        final @NotNull List<Expectation> expectations = expectationDefinitions.stream()
                .map(expectationDefinition -> expectationParser.parseExpectation(expectationDefinition, mocks))
                .collect(Collectors.toList());

        expectations.forEach(expectation ->
                classAndMethodsThatRequireExpectation.add(
                        new ClassAndMethodImpl(expectation.getInvocationClassName(), expectation.getInvocationMethodName())
                )
        );

        return new ExpectationsImpl(expectations, classAndMethodsThatRequireExpectation, expectationsType);
    }
}
