package com.silensoft.micromock.mockdb.jdbcdriver.exception;

import com.silensoft.micromock.mockdb.jdbcdriver.failurereporter.FailureReporterImpl;
import org.jetbrains.annotations.NotNull;

public class ReportableException extends RuntimeException {

    public ReportableException(final @NotNull String message) {
        super(message);
        new FailureReporterImpl().reportFailure(message);
    }
}
