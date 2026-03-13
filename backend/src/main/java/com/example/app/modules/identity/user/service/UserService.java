package com.example.app.modules.identity.user.service;

import com.example.app.modules.identity.user.dto.request.CreateUserRequest;
import com.example.app.modules.identity.user.dto.request.UpdateUserRequest;
import com.example.app.modules.identity.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(CreateUserRequest request);
    List<UserResponse> list();
    UserResponse update(Long id, UpdateUserRequest request);
}
