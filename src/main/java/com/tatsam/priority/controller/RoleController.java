package com.tatsam.priority.controller;

import com.tatsam.priority.dto.RoleData;
import com.tatsam.priority.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/api/v1/add/role")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public RoleData addRole(@RequestBody(required = true) final String roleName) throws Exception{
        return roleService.addRole(roleName);
    }
}
