package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

@SuppressWarnings("UseOfJDBCDriverClass")
public class MockDbDriverImpl implements MockDbDriver {

    private static final String MOCKDB_CONNECTION_URL_START = "jdbc:mockdb://";
    private static @NotNull Optional<MockDbDriver> registeredDriver = Optional.empty();

    static {
        try {
            registerMockDbDriver();
        } catch (final SQLException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    @Override
    public @Nullable Connection connect(final String connectionUrl, final Properties info) {
        if (connectionUrl.startsWith(MOCKDB_CONNECTION_URL_START) && registeredDriver.isPresent()) {
            final int questionMarkPositionInConnectionUrl = connectionUrl.indexOf('?');
            final String mockDbHostAndPort = connectionUrl.substring(MOCKDB_CONNECTION_URL_START.length(),
                    questionMarkPositionInConnectionUrl == -1 ? connectionUrl.length() : questionMarkPositionInConnectionUrl);
            return new MockDbConnection(mockDbHostAndPort);
        }

        return null;
    }

    @Override
    public boolean acceptsURL(final String url) {
        return url.startsWith("jdbc:mockdb:");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(final String url, final Properties info) {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    private static void registerMockDbDriver() throws SQLException {
        if (registeredDriver.isPresent()) {
            return;
        }

        final MockDbDriver newMockDbDriver = new MockDbDriverImpl();
        DriverManager.registerDriver(newMockDbDriver);
        MockDbDriverImpl.registeredDriver = Optional.of(newMockDbDriver);
    }


}
