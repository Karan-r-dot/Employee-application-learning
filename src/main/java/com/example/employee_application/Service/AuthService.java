package com.example.employee_application.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.employee_application.Entity.LoginRequestDto;
import com.example.employee_application.Entity.RegisterRequestDto;
import com.example.employee_application.Entity.User;
import com.example.employee_application.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

	public String registerUser(RegisterRequestDto registerRequestDto) {
		
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        user.setRole(registerRequestDto.getRole());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        userRepository.save(user);
        return "User saved successfully";

	}

    public String loginUser(LoginRequestDto loginRequestDto) {
        
       User user = userRepository.findByUsername(loginRequestDto.getUsername());
       if(user == null){
        return "User not found";
       }

       boolean isPasswordValid = passwordEncoder.matches(loginRequestDto.getPassword(),user.getPassword());

       if(!isPasswordValid){
        return "Password is not valid";
       }

       return jwtService.generateToken(user.getUsername());
    }

}
