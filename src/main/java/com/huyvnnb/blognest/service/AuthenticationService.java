package com.huyvnnb.blognest.service;

import com.huyvnnb.blognest.dto.request.AuthenticationRequest;
import com.huyvnnb.blognest.dto.response.AuthenticationResponse;
import com.huyvnnb.blognest.exception.AppException;
import com.huyvnnb.blognest.exception.ErrorCode;
import com.huyvnnb.blognest.repository.UserRepository;
import com.huyvnnb.blognest.utils.JwtTokenUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    JwtTokenUtils jwtToken;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        String token = jwtToken.generateToken(user.getEmail());
        return AuthenticationResponse.builder()
                .authenticated(true)
                .token(token)
                .build();
    }


}
