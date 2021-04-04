package com.fakeBlog.controllers;

import com.fakeBlog.entity.RoleEntity;
import com.fakeBlog.entity.UserEntity;
import com.fakeBlog.model.AuthRequest;
import com.fakeBlog.model.AuthResponse;
import com.fakeBlog.model.RegistrationRequest;
import com.fakeBlog.services.UserService;
import com.fakeBlog.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        u.setRoleEntity(new RoleEntity("USER"));
        return ResponseEntity.ok(userService.saveUser(u));
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
