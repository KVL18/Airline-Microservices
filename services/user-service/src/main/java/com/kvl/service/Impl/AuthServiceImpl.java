package com.kvl.service.Impl;

import com.kvl.config.JwtProvider;
import com.kvl.enums.UserRole;
import com.kvl.mapper.UserMapper;
import com.kvl.model.User;
import com.kvl.payload.dto.UserDTO;
import com.kvl.payload.response.AuthResponse;
import com.kvl.repository.UserRepository;
import com.kvl.service.AuthService;
import com.kvl.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public final JwtProvider jwtProvider;
    private final CustomUserDetailsService customUserDetailsService;
    /*
    check if email already exist or not
    2.Encode password using Bcrypt
    3.save user in db
    4.Genaerate jwt token
    5.Return token and user info.
     */

    @Override
    public AuthResponse signup(UserDTO req) throws Exception {
        User existingUser =userRepository.findByEmail(req.getEmail());
        if(existingUser!=null){
            throw new Exception("email already registered");
        }
        if(req.getRole() == UserRole.ROLE_SYSTEM_ADMIN){
            throw new Exception("You cannot SignUp as System Admin");
        }
        User newUser = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .phone(req.getPhone())
                .role(req.getRole())
                .fullName(req.getFullName())
                .lastLogin(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                savedUser.getEmail(),
                savedUser.getPassword()
        );
        String jwt = jwtProvider.generateToken(
                authentication,savedUser.getId()
        );
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setUser(UserMapper.toDTO(savedUser));
        authResponse.setTitle("Welcome" + savedUser);
        authResponse.setMessage("Registered Successfully");
        return authResponse;

    }

    @Override
    public AuthResponse login(String email, String password) throws Exception {
        Authentication authentication = authentication(email,password);
        User user = userRepository.findByEmail(email);
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
        String jwt = jwtProvider.generateToken(authentication, user.getId());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setUser(UserMapper.toDTO(user));
        authResponse.setTitle("Welcome" + user);
        authResponse.setMessage("Registered Successfully");
        return authResponse;


    }

    private Authentication authentication(String email, String password) throws Exception {
        UserDetails userDetails =  customUserDetailsService.loadUserByUsername(email);
       if(!passwordEncoder.matches(
               password , userDetails.getPassword()
       )){
           throw new Exception("Invalid Password");
       }
       return new UsernamePasswordAuthenticationToken(userDetails,null,
               userDetails.getAuthorities());

    }


}
