package com.example.app.modules.identity.role.service.impl;

import com.example.app.modules.identity.role.entity.Role;
import com.example.app.modules.identity.role.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> list() {
        return List.of(Role.ADMIN, Role.OFFICE);
    }
}
