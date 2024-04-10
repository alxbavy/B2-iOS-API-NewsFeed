package com.poly.authentication.api;

import com.poly.authentication.service.RoleService;
import com.poly.authentication.service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class KeycloakRoleApi {

    private final RoleService roleService;

    public KeycloakRoleApi(RoleService roleService) {
        this.roleService = roleService;
    }

    @PutMapping("/assign-role/user/{userId}")
    public ResponseEntity<?> assignRole(@PathVariable String userId, @RequestParam String roleName){

        roleService.assignRole(userId, roleName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

