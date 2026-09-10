package com.example.employee_application.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_application.Entity.LoginRequestDto;
import com.example.employee_application.Entity.RegisterRequestDto;
import com.example.employee_application.Service.AuthService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequestDto registerRequestDto){

        return authService.registerUser(registerRequestDto);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequestDto loginRequestDto){

        return authService.loginUser(loginRequestDto);
    }

}
