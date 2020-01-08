package com.silensoft.micromock.mockdb.jdbcdriver;

import com.google.inject.AbstractModule;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.*;
import com.silensoft.micromock.mockdb.jdbcdriver.failurereporter.FailureReporter;
import com.silensoft.micromock.mockdb.jdbcdriver.failurereporter.FailureReporterImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.InvocationCountParser;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.InvocationCountParserImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationFactory;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationFactoryImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcherParser;
import com.silensoft.micromock.mockdb.jdbcdriver.methodinvocation.MethodInvocationMatcherParserImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockParser;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.MockParserImpl;
import com.silensoft.micromock.mockdb.jdbcdriver.result.ResultParser;
import com.silensoft.micromock.mockdb.jdbcdriver.result.ResultParserImpl;

public class MockDbJdbcDriverModule extends AbstractModule {

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void configure() {
        bind(ExpectationParser.class).to(ExpectationParserImpl.class).asEagerSingleton();
        bind(ExpectationsFactory.class).to(ExpectationsFactoryImpl.class).asEagerSingleton();
        bind(MethodInvocationMatcherParser.class).to(MethodInvocationMatcherParserImpl.class).asEagerSingleton();
        bind(ResultParser.class).to(ResultParserImpl.class).asEagerSingleton();
        bind(InvocationCountParser.class).to(InvocationCountParserImpl.class).asEagerSingleton();
        bind(MockParser.class).to(MockParserImpl.class).asEagerSingleton();
        bind(FailureReporter.class).to(FailureReporterImpl.class).asEagerSingleton();
        bind(MethodInvocationFactory.class).to(MethodInvocationFactoryImpl.class).asEagerSingleton();
        bind(ExpectationDefinitionsStore.class).to(ExpectationDefinitionsStoreImpl.class).asEagerSingleton();
        bind(ExpectationFactory.class).to(ExpectationFactoryImpl.class).asEagerSingleton();
    }

}
