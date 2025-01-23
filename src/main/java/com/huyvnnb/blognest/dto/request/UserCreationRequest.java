package com.huyvnnb.blognest.dto.request;

import com.huyvnnb.blognest.exception.ErrorCode;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Email(message = "INVALID_EMAIL")
    String email;

    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;

    @NotNull(message = "Firstname is required")
    String firstName;
    @NotNull(message = "Lastname is required")
    String lastName;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate dob;
}
