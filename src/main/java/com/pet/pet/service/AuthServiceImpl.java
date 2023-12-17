package com.pet.pet.service;


import com.pet.pet.dto.SignupRequest;
import com.pet.pet.dto.UserDTO;
import com.pet.pet.model.User;
import com.pet.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDTO createUser(SignupRequest signupRequest) {
//        User user = new User();
//        user.setEmail(signupRequest.getEmail());
//        user.setName(signupRequest.getName());
//        user.setPhone(signupRequest.getPhone());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
//        User createdUser = userRepository.save(user);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail(createdUser.getEmail());
//        userDTO.setName(createdUser.getName());
//        userDTO.setPhone(createdUser.getPhone());
//        return userDTO;
//    }
}
