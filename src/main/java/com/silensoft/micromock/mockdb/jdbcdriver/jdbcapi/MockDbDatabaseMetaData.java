package com.silensoft.micromock.mockdb.jdbcdriver.jdbcapi;

import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbException;
import com.silensoft.micromock.mockdb.jdbcdriver.exception.MockDbExceptionType;
import com.silensoft.micromock.mockdb.jdbcdriver.expectation.Expectations;
import com.silensoft.micromock.mockdb.jdbcdriver.mock.Mock;
import com.silensoft.micromock.mockdb.jdbcdriver.value.*;
import com.sun.jdi.IntegerType;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ClassWithTooManyMethods")
public class MockDbDatabaseMetaData implements DatabaseMetaData {

    private static final String DATABASE_METADATA = "DatabaseMetaData";

    private final @NotNull Expectations expectations;
    private final @NotNull Optional<Mock> optDatabaseMetaDataMock;

    public MockDbDatabaseMetaData(final @NotNull Expectations newExpectations, final @NotNull Optional<Mock> newDatabaseMetaDataMock) {
        expectations = newExpectations;
        optDatabaseMetaDataMock = newDatabaseMetaDataMock;
    }

    @Override
    public boolean allProceduresAreCallable() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "allProceduresAreCallable"))
                .orElse(true);
    }

    @Override
    public boolean allTablesAreSelectable() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "allTablesAreCallable"))
                .orElse(true);
    }

    @Override
    public String getURL() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getUrl"))
                .orElse("");
    }

    @Override
    public String getUserName() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getUserName"))
                .orElse("");
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "isReadOnly"))
                .orElse(true);
    }

    @Override
    public boolean nullsAreSortedHigh() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "nullsAreSortedHigh"))
                .orElse(true);
    }

    @Override
    public boolean nullsAreSortedLow() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "nullsAreSortedLow"))
                .orElse(true);
    }

    @Override
    public boolean nullsAreSortedAtStart() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "nullsAreSortedAtStart"))
                .orElse(true);
    }

    @Override
    public boolean nullsAreSortedAtEnd() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "nullsAreSortedAtEnd"))
                .orElse(true);
    }

    @Override
    public String getDatabaseProductName() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDatabaseProductName"))
                .orElse("");
    }

    @Override
    public String getDatabaseProductVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDatabaseProductVersion"))
                .orElse("");
    }

    @Override
    public String getDriverName() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDriverName"))
                .orElse("");
    }

    @Override
    public String getDriverVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDriverVersion"))
                .orElse("");
    }

    @Override
    public int getDriverMajorVersion() {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDriverMajorVersion"))
                .orElse(0);
    }

    @Override
    public int getDriverMinorVersion() {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDriverMinorVersion"))
                .orElse(0);
    }

    @Override
    public boolean usesLocalFiles() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "usesLocalFiles"))
                .orElse(true);
    }

    @Override
    public boolean usesLocalFilePerTable() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "usesLocalFilePerTable"))
                .orElse(true);
    }

    @Override
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMixedCaseIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesUpperCaseIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesLowerCaseIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesMixedCaseIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMixedCaseQuotedIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesUpperCaseQuotedIdentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesLowerCaseIQuotedidentifiers"))
                .orElse(true);
    }

    @Override
    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "storesMixedCaseQuotedIdentifiers"))
                .orElse(true);
    }

    @Override
    public String getIdentifierQuoteString() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getIdentifierQuoteString"))
                .orElse("");
    }

    @Override
    public String getSQLKeywords() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSQLKeywords"))
                .orElse("");
    }

    @Override
    public String getNumericFunctions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getNumericFunctions"))
                .orElse("");
    }

    @Override
    public String getStringFunctions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getStringFunctions"))
                .orElse("");
    }

    @Override
    public String getSystemFunctions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSystemFunctions"))
                .orElse("");
    }

    @Override
    public String getTimeDateFunctions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getTimeDateFunctions"))
                .orElse("");
    }

    @Override
    public String getSearchStringEscape() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSearchStringEscape"))
                .orElse("");
    }

    @Override
    public String getExtraNameCharacters() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getExtraNameCharacters"))
                .orElse("");
    }

    @Override
    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getIdentifierQuoteString"))
                .orElse(true);
    }

    @Override
    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsAlterTableWithDropColumn"))
                .orElse(true);
    }

    @Override
    public boolean supportsColumnAliasing() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsColumnAliasing"))
                .orElse(true);
    }

    @Override
    public boolean nullPlusNonNullIsNull() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "nullPlusNonNullIsNull"))
                .orElse(true);
    }

    @Override
    public boolean supportsConvert() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsConvert"))
                .orElse(true);
    }

    @Override
    public boolean supportsConvert(final int fromType, final int toType) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsConvert",
                        List.of(new IntegerValue(fromType), new IntegerValue(toType))))
                .orElse(true);
    }

    @Override
    public boolean supportsTableCorrelationNames() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsTableCorrelationNames"))
                .orElse(true);
    }

    @Override
    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsDifferentTableCorrelationNames"))
                .orElse(true);
    }

    @Override
    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsExpressionsInOrderBy"))
                .orElse(true);
    }

    @Override
    public boolean supportsOrderByUnrelated() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOrderByUnrelated"))
                .orElse(true);
    }

    @Override
    public boolean supportsGroupBy() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsGroupBy"))
                .orElse(true);
    }

    @Override
    public boolean supportsGroupByUnrelated() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsGroupByUnrelated"))
                .orElse(true);
    }

    @Override
    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsGroupByBeyondSelect"))
                .orElse(true);
    }

    @Override
    public boolean supportsLikeEscapeClause() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsLikeEscapeClause"))
                .orElse(true);
    }

    @Override
    public boolean supportsMultipleResultSets() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMultipleResultSets"))
                .orElse(true);
    }

    @Override
    public boolean supportsMultipleTransactions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMultipleTransactions"))
                .orElse(true);
    }

    @Override
    public boolean supportsNonNullableColumns() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsNonNullableColumns"))
                .orElse(true);
    }

    @Override
    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMinimumSQLGrammar"))
                .orElse(true);
    }

    @Override
    public boolean supportsCoreSQLGrammar() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCoreSQLGrammar"))
                .orElse(true);
    }

    @Override
    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsExtendedSQLGrammar"))
                .orElse(true);
    }

    @Override
    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsANSI92EntryLevelSQL"))
                .orElse(true);
    }

    @Override
    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsANSI92IntermediateSQL"))
                .orElse(true);
    }

    @Override
    public boolean supportsANSI92FullSQL() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsANSI92FullSQL"))
                .orElse(true);
    }

    @Override
    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsIntegrityEnhancementFacility"))
                .orElse(true);
    }

    @Override
    public boolean supportsOuterJoins() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOuterJoins"))
                .orElse(true);
    }

    @Override
    public boolean supportsFullOuterJoins() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsFullOuterJoins"))
                .orElse(true);
    }

    @Override
    public boolean supportsLimitedOuterJoins() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsLimitedOuterJoins"))
                .orElse(true);
    }

    @Override
    public String getSchemaTerm() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSchemaTerm"))
                .orElse("");
    }

    @Override
    public String getProcedureTerm() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getProcedureTerm"))
                .orElse("");
    }

    @Override
    public String getCatalogTerm() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getCatalogTerm"))
                .orElse("");
    }

    @Override
    public boolean isCatalogAtStart() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "isCatalogAtStart"))
                .orElse(true);
    }

    @Override
    public String getCatalogSeparator() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnStringResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getCatalogSeparator"))
                .orElse("");
    }

    @Override
    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSchemasInDataManipulation"))
                .orElse(true);
    }

    @Override
    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSchemasInProcedureCalls"))
                .orElse(true);
    }

    @Override
    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSchemasInTableDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSchemasInIndexDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSchemasInPrivilegeDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCatalogsInDataManipulation"))
                .orElse(true);
    }

    @Override
    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCatalogsInProcedureCalls"))
                .orElse(true);
    }

    @Override
    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCatalogsInTableDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCatalogsInIndexDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCatalogsInPrivilegeDefinitions"))
                .orElse(true);
    }

    @Override
    public boolean supportsPositionedDelete() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsPositionedDelete"))
                .orElse(true);
    }

    @Override
    public boolean supportsPositionedUpdate() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsPositionedUpdate"))
                .orElse(true);
    }

    @Override
    public boolean supportsSelectForUpdate() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSelectForUpdate"))
                .orElse(true);
    }

    @Override
    public boolean supportsStoredProcedures() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsStoredProcedures"))
                .orElse(true);
    }

    @Override
    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSubqueriesInComparisons"))
                .orElse(true);
    }

    @Override
    public boolean supportsSubqueriesInExists() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSubqueriesInExists"))
                .orElse(true);
    }

    @Override
    public boolean supportsSubqueriesInIns() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSubqueriesInIns"))
                .orElse(true);
    }

    @Override
    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSubqueriesInQuantifieds"))
                .orElse(true);
    }

    @Override
    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsCorrelatedSubqueries"))
                .orElse(true);
    }

    @Override
    public boolean supportsUnion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsUnion"))
                .orElse(true);
    }

    @Override
    public boolean supportsUnionAll() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsUnionAll"))
                .orElse(true);
    }

    @Override
    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOpenCursorsAcrossCommit"))
                .orElse(true);
    }

    @Override
    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOpenCursorsAcrossRollback"))
                .orElse(true);
    }

    @Override
    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOpenStatementsAcrossCommit"))
                .orElse(true);
    }

    @Override
    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsOpenStatementsAcrossRollback"))
                .orElse(true);
    }

    @Override
    public int getMaxBinaryLiteralLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxBinaryLiteralLength"))
                .orElse(0);
    }

    @Override
    public int getMaxCharLiteralLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxCharLiteralLength"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnsInGroupBy() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnsInGroupBy"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnsInIndex() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnsInIndex"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnsInOrderBy() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnsInOrderBy"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnsInSelect() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnsInSelect"))
                .orElse(0);
    }

    @Override
    public int getMaxColumnsInTable() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxColumnsInTable"))
                .orElse(0);
    }

    @Override
    public int getMaxConnections() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxConnections"))
                .orElse(0);
    }

    @Override
    public int getMaxCursorNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxCursorNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxIndexLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxIndexLength"))
                .orElse(0);
    }

    @Override
    public int getMaxSchemaNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxSchemaNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxProcedureNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxProcedureNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxCatalogNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxCatalogNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxRowSize() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxRowSize"))
                .orElse(0);
    }

    @Override
    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "doesMaxRowSizeIncludeBlobs"))
                .orElse(true);
    }

    @Override
    public int getMaxStatementLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxStatementLength"))
                .orElse(0);
    }

    @Override
    public int getMaxStatements() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxStatements"))
                .orElse(0);
    }

    @Override
    public int getMaxTableNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxTableNameLength"))
                .orElse(0);
    }

    @Override
    public int getMaxTablesInSelect() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxTablesInSelect"))
                .orElse(0);
    }

    @Override
    public int getMaxUserNameLength() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getMaxUserNameLength"))
                .orElse(0);
    }

    @Override
    public int getDefaultTransactionIsolation() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDefaultTransactionIsolation"))
                .orElse(0);
    }

    @Override
    public boolean supportsTransactions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsTransactions"))
                .orElse(true);
    }

    @Override
    public boolean supportsTransactionIsolationLevel(final int level) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsTransactions",
                        List.of(new IntegerValue(level))))
                .orElse(true);
    }

    @Override
    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsDataDefinitionAndDataManipulationTransactions"))
                .orElse(true);
    }

    @Override
    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsDataManipulationTransactionsOnly"))
                .orElse(true);
    }

    @Override
    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "dataDefinitionCausesTransactionCommit"))
                .orElse(true);
    }

    @Override
    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "dataDefinitionIgnoredInTransactions"))
                .orElse(true);
    }

    @Override
    public ResultSet getProcedures(final String catalog, final String schemaPattern, final String procedureNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getProcedures",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue (procedureNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getProcedureColumns(
            final String catalog,
            final String schemaPattern,
            final String procedureNamePattern,
            final String columnNamePattern
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getProcedureColumns",
                        List.of(
                                new StringValue(catalog),
                                new StringValue(schemaPattern),
                                new StringValue (procedureNamePattern),
                                new StringValue(columnNamePattern)
                        ),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getTables(final String catalog, final String schemaPattern, final String tableNamePattern, final String[] types) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getProcedures",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(tableNamePattern), new StringArrayValue(types)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getSchemas() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSchemas",
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getCatalogs() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getCatalogs",
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getTableTypes() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getTableTypes",
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getColumns(
            final String catalog,
            final String schemaPattern,
            final String tableNamePattern,
            final String columnNamePattern
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getColumns",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(tableNamePattern), new StringValue(columnNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getColumnPrivileges(final String catalog, final String schema, final String table, final String columnNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getColumnPrivileges",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table), new StringValue(columnNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getTablePrivileges(final String catalog, final String schemaPattern, final String tableNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getTablePrivileges",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(tableNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getBestRowIdentifier(
            final String catalog,
            final String schema,
            final String table,
            final int scope,
            final boolean nullable
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getBestRowIdentifier",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table), new IntegerValue(scope), new BooleanValue(nullable)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getVersionColumns(final String catalog, final String schema, final String table) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getVersionColumns",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getPrimaryKeys(final String catalog, final String schema, final String table) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getPrimaryKeys",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getImportedKeys(final String catalog, final String schema, final String table) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getProcedures",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getExportedKeys(final String catalog, final String schema, final String table) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getExportedKeys",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getCrossReference(
            final String parentCatalog,
            final String parentSchema,
            final String parentTable,
            final String foreignCatalog,
            final String foreignSchema,
            final String foreignTable
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getCrossReference",
                        List.of(
                                new StringValue(parentCatalog),
                                new StringValue(parentSchema),
                                new StringValue(parentTable),
                                new StringValue(foreignCatalog),
                                new StringValue(foreignSchema),
                                new StringValue(foreignTable)
                        ),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getTypeInfo() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getTypeInfo",
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getIndexInfo(
            final String catalog,
            final String schema,
            final String table,
            final boolean unique,
            final boolean approximate
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getIndexInfo",
                        List.of(new StringValue(catalog), new StringValue(schema), new StringValue(table), new BooleanValue(unique), new BooleanValue(approximate)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public boolean supportsResultSetType(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsResultSetType",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean supportsResultSetConcurrency(final int type, final int concurrency) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsResultSetConcurrency",
                        List.of(new IntegerValue(type), new IntegerValue(concurrency))))
                .orElse(true);
    }

    @Override
    public boolean ownUpdatesAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "ownUpdatesAreVisible",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean ownDeletesAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "ownDeletesAreVisible",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean ownInsertsAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "ownInsertsAreVisible",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean othersUpdatesAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "othersUpdatesAreVisible",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean othersDeletesAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "othersDeletesAreVisible",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean othersInsertsAreVisible(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "othersInsertsAreVisiable",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean updatesAreDetected(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "updatesAreDetected",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean deletesAreDetected(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "deletesAreDetected",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean insertsAreDetected(final int type) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "insertsAreDetected",
                        List.of(new IntegerValue(type))))
                .orElse(true);
    }

    @Override
    public boolean supportsBatchUpdates() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "ownDeletesAreVisible"))
                .orElse(true);
    }

    @Override
    public ResultSet getUDTs(final String catalog, final String schemaPattern, final String typeNamePattern, final int[] types) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getUDTs",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(typeNamePattern), new IntegerArrayValue(types)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public Connection getConnection() throws SQLException {
        // TODO: implement
        return null;
    }

    @Override
    public boolean supportsSavepoints() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsSavepoints"))
                .orElse(true);
    }

    @Override
    public boolean supportsNamedParameters() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsNamedParameters"))
                .orElse(true);
    }

    @Override
    public boolean supportsMultipleOpenResults() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsMultipleOpenResults"))
                .orElse(true);
    }

    @Override
    public boolean supportsGetGeneratedKeys() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsGetGeneratedKeys"))
                .orElse(true);
    }

    @Override
    public ResultSet getSuperTypes(final String catalog, final String schemaPattern, final String typeNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSuperTypes",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(typeNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getSuperTables(final String catalog, final String schemaPattern, final String tableNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getUDTs",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(tableNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getAttributes(
            final String catalog,
            final String schemaPattern,
            final String typeNamePattern,
            final String attributeNamePattern
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getAttributes",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(typeNamePattern), new StringValue(attributeNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public boolean supportsResultSetHoldability(final int holdability) throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsResultSetHoldability",
                        List.of(new IntegerValue(holdability))))
                .orElse(true);
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getResultSetHoldability"))
                .orElse(0);
    }

    @Override
    public int getDatabaseMajorVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDatabaseMajorVersion"))
                .orElse(0);
    }

    @Override
    public int getDatabaseMinorVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getDatabaseMinorVersion"))
                .orElse(0);
    }

    @Override
    public int getJDBCMajorVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getJDBCMajorVersion"))
                .orElse(0);
    }

    @Override
    public int getJDBCMinorVersion() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getJDBCMinorVersion"))
                .orElse(0);
    }

    @Override
    public int getSQLStateType() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnIntegerResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSQLStateType"))
                .orElse(0);
    }

    @Override
    public boolean locatorsUpdateCopy() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "locatorsUpdateCopy"))
                .orElse(true);
    }

    @Override
    public boolean supportsStatementPooling() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsStatementPooling"))
                .orElse(true);
    }

    @Override
    public RowIdLifetime getRowIdLifetime() throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public ResultSet getSchemas(final String catalog, final String schemaPattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getSchemas",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "supportsStoredFunctionsUsingCallSyntax"))
                .orElse(true);
    }

    @Override
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "autoCommitFailureClosesAllResultSets"))
                .orElse(true);
    }

    @Override
    public ResultSet getClientInfoProperties() throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getClientInfoProperties",
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getFunctions(final String catalog, final String schemaPattern, final String functionNamePattern) throws SQLException {
        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getFunctions",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(functionNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getFunctionColumns(
            final String catalog,
            final String schemaPattern,
            final String functionNamePattern,
            final String columnNamePattern
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getFunctionColumns",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(functionNamePattern), new StringValue(columnNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public ResultSet getPseudoColumns(
            final String catalog,
            final String schemaPattern,
            final String tableNamePattern,
            final String columnNamePattern
    ) throws SQLException {

        final @NotNull Optional<Mock> resultSetMock = optDatabaseMetaDataMock.flatMap(databaseMetaDataMock ->
                expectations.matchAndReturnMockResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "getPseudoColumns",
                        List.of(new StringValue(catalog), new StringValue(schemaPattern), new StringValue(tableNamePattern), new StringValue(columnNamePattern)),
                        "ResultSet")
        );

        return new MockDbResultSet(expectations, resultSetMock);
    }

    @Override
    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return optDatabaseMetaDataMock
                .flatMap(databaseMetaDataMock -> expectations.matchAndReturnBooleanResult(
                        DATABASE_METADATA,
                        databaseMetaDataMock.getName(),
                        "generatedKeyAlwaysReturned"))
                .orElse(true);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new MockDbException(MockDbExceptionType.UNSUPPORTED_JDBC_API_OPERATION);
    }
}
