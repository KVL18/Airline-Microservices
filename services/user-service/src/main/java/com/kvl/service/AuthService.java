package com.kvl.service;

import com.kvl.payload.dto.UserDTO;
import com.kvl.payload.response.AuthResponse;

public interface AuthService  {

    AuthResponse login(String email , String password) throws Exception;
    AuthResponse signup(UserDTO req) throws Exception;


}
