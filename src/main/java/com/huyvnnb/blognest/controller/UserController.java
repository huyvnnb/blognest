package com.huyvnnb.blognest.controller;

import com.huyvnnb.blognest.dto.request.UserCreationRequest;
import com.huyvnnb.blognest.dto.response.ApiResponse;
import com.huyvnnb.blognest.dto.response.UserResponse;
import com.huyvnnb.blognest.entity.User;
import com.huyvnnb.blognest.mapper.UserMapper;
import com.huyvnnb.blognest.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        var result = userService.createUser(request);
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.CREATED.value())
                .result(result)
                .build();
    }

    @GetMapping("/users")
    public ApiResponse<List<UserResponse>> getUsers(){
        var result = userService.getUsers();

        return ApiResponse.<List<UserResponse>>builder()
                .code(HttpStatus.OK.value())
                .result(result)
                .build();
    }
}
