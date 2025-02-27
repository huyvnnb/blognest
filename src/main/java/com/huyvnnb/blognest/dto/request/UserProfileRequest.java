package com.huyvnnb.blognest.dto.request;


import com.huyvnnb.blognest.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileRequest {
    String nickname;
    String firstName;
    String lastName;
    String avatar;
    Gender gender;
    LocalDate dob;
}
