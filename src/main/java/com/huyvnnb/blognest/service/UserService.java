package com.huyvnnb.blognest.service;

import com.huyvnnb.blognest.dto.request.UserCreationRequest;
import com.huyvnnb.blognest.dto.response.UserResponse;
import com.huyvnnb.blognest.entity.User;
import com.huyvnnb.blognest.exception.AppException;
import com.huyvnnb.blognest.exception.ErrorCode;
import com.huyvnnb.blognest.mapper.UserMapper;
import com.huyvnnb.blognest.repository.UserRepository;
import com.huyvnnb.blognest.util.Role;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;


    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        user.setRole(Role.USER);

        return userMapper.toUserResponse(userRepository.save(user));
    }
    
    public List<UserResponse> getUsers(){
        if(userRepository.findAll().isEmpty()){
            throw new AppException(ErrorCode.USER_LIST_EMPTY);
        }
        return userRepository.findAll().stream()
                .map(user -> userMapper.toUserResponse(user))
                .toList();
    }
}
