package com.example.app.modules.identity.role.repository;

import com.example.app.modules.identity.role.entity.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
}
