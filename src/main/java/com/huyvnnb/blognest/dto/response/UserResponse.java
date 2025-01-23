package com.huyvnnb.blognest.dto.response;

import com.huyvnnb.blognest.util.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String email;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    Role role;
}
