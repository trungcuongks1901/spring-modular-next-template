package com.example.app.modules.identity.auth.service;

import com.example.app.modules.identity.auth.dto.request.LoginRequest;
import com.example.app.modules.identity.auth.dto.response.LoginResponse;

public interface AuthService { LoginResponse login(LoginRequest request); }
