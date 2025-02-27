package com.huyvnnb.blognest.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    @NotNull(message = "Email must not be empty")
    String email;
    @NotNull(message = "Password must not be empty")
    String password;
}
