package com.kvl.service;

import com.kvl.model.User;
import com.kvl.payload.dto.UserDTO;

import java.util.List;

public  interface UserService {

    UserDTO getUserByEmail(String email) throws Exception;
    UserDTO getUserById(Long id) throws Exception;
    List<UserDTO>getAllUsers();
}
