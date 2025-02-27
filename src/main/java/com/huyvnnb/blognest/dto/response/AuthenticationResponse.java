package com.huyvnnb.blognest.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthenticationResponse {
    boolean authenticated;
    String token;
}
