package com.huyvnnb.blognest.controller;

import com.huyvnnb.blognest.dto.request.AuthenticationRequest;
import com.huyvnnb.blognest.dto.response.ApiResponse;
import com.huyvnnb.blognest.dto.response.AuthenticationResponse;
import com.huyvnnb.blognest.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authService.authenticate(request))
                .message("Login successfully")
                .build()
        ;
    }
}
