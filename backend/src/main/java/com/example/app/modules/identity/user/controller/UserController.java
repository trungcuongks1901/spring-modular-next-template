package com.example.app.modules.identity.user.controller;

import com.example.app.modules.identity.user.dto.request.CreateUserRequest;
import com.example.app.modules.identity.user.dto.request.UpdateUserRequest;
import com.example.app.modules.identity.user.dto.response.UserResponse;
import com.example.app.modules.identity.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping public UserResponse create(@Valid @RequestBody CreateUserRequest request) { return userService.create(request); }
    @GetMapping public List<UserResponse> list() { return userService.list(); }
    @PutMapping("/{id}") public UserResponse update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) { return userService.update(id, request); }
}
