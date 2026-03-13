package com.example.app.modules.identity.user.service.impl;

import com.example.app.modules.identity.user.dto.request.CreateUserRequest;
import com.example.app.modules.identity.user.dto.request.UpdateUserRequest;
import com.example.app.modules.identity.user.dto.response.UserResponse;
import com.example.app.modules.identity.user.entity.User;
import com.example.app.modules.identity.user.repository.UserRepository;
import com.example.app.modules.identity.user.service.UserService;
import com.example.app.modules.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }
    public UserResponse create(CreateUserRequest request) {
        Long id = userRepository.findAll().stream().mapToLong(User::id).max().orElse(0L) + 1;
        return map(userRepository.save(new User(id, request.username(), request.password(), request.role(), request.officeId(), request.active())));
    }
    public List<UserResponse> list() { return userRepository.findAll().stream().map(this::map).toList(); }
    public UserResponse update(Long id, UpdateUserRequest request) {
        User existing = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return map(userRepository.save(new User(id, request.username(), existing.password(), request.role(), request.officeId(), request.active())));
    }
    private UserResponse map(User user) { return new UserResponse(user.id(), user.username(), user.role(), user.officeId(), user.active()); }
}
