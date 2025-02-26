package com.huyvnnb.blognest.dto.response;

import com.huyvnnb.blognest.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String email;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    Role role;
}
