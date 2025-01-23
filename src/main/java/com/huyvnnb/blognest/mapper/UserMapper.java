package com.huyvnnb.blognest.mapper;

import com.huyvnnb.blognest.dto.request.UserCreationRequest;
import com.huyvnnb.blognest.dto.response.UserResponse;
import com.huyvnnb.blognest.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);

    User toUser(UserCreationRequest request);
}
