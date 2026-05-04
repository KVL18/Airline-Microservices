package com.kvl.controller;


import com.kvl.mapper.UserMapper;
import com.kvl.model.User;
import com.kvl.payload.dto.UserDTO;
import com.kvl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.security.PrivateKey;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(
            @RequestHeader("X-user-Email") String email
    ) throws Exception {
        UserDTO user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable Long userId
    )throws Exception{
        UserDTO user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

