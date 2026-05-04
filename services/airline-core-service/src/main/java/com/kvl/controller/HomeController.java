package com.kvl.controller;


import com.kvl.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public ApiResponse homeController(){
        ApiResponse apiResponse = new ApiResponse(
                "Hey everyone i am homeController of airline-core-service"
        );
        return  apiResponse;
    }
}
