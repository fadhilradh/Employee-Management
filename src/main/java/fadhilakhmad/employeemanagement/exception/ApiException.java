package fadhilakhmad.employeemanagement.exception;

import fadhilakhmad.employeemanagement.config.AppConfig;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {

    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.throwable = AppConfig.isStackTraceEnabled ? throwable : null;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
}
