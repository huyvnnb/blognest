package com.huyvnnb.blognest.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    INVALID_EMAIL(1001, "You must enter email as username", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1002, "Password must be at least 6 character", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1101, "User existed", HttpStatus.BAD_REQUEST),
    USER_LIST_EMPTY(1011, "User list is empty", HttpStatus.BAD_REQUEST),

    UNDEFINED_ERROR(5001, "Some error has occured", HttpStatus.BAD_REQUEST);

    ;

    int code;
    String message;
    HttpStatusCode statusCode;
}
