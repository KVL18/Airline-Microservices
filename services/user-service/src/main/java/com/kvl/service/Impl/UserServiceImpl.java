package com.kvl.service.Impl;

import com.kvl.mapper.UserMapper;
import com.kvl.model.User;
import com.kvl.payload.dto.UserDTO;
import com.kvl.repository.UserRepository;
import com.kvl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO getUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user ==null){
            throw new Exception("user not found with this email");
        }
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) throws Exception {
        User user =userRepository.findById(id).orElseThrow(
                ()->new Exception("USER NOT FOUND WITH THAT ID")
        );
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDTOList(users);
    }
}
