package com.kvl.controller;


import com.kvl.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {


    @GetMapping("/")
    public ApiResponse HomeController(){
        ApiResponse apiResponse = new ApiResponse("hey i am user service");
        return apiResponse;
    }
}
