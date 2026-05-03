package com.kvl.payload.response;


import lombok.Data;

@Data
public class LoginRequest {
    private  String email;
    private String password;

}
