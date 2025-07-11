package com.example.service;

import com.example.exceptions.UserAlreadyExistsException;
import com.example.model.UserCredentials;
import com.example.model.Users;
import com.example.repo.CourseRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;


    public Users register(Users user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username is already taken");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(UserCredentials credentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
        );

        if (authentication.isAuthenticated()) {

            Users user = userRepository.findByUsername(credentials.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));


            UserCredentials fullCredentials = new UserCredentials(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword()
            );

            return jwtService.generateToken(fullCredentials);
        }

        return "Invalid username or password";
    }

    @Override
    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }




}
