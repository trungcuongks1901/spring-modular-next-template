package com.example.app.modules.identity.role.controller;

import com.example.app.modules.identity.role.dto.response.RoleResponse;
import com.example.app.modules.identity.role.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) { this.roleService = roleService; }

    @GetMapping
    public List<RoleResponse> list() {
        return roleService.list().stream().map(role -> new RoleResponse(role.name())).toList();
    }
}
