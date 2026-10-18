package com.athletics.athletics_management.service;

import com.athletics.athletics_management.entity.Role;
import com.athletics.athletics_management.entity.User;
import com.athletics.athletics_management.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(
            String username,
            String email,
            String password,
            String fullName,
            Role role) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException(
                    "Tên đăng nhập đã tồn tại!");
        }
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException(
                    "Email đã được sử dụng!");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);
        user.setRole(role);
        user.setEnabled(true);
        return userRepository.save(user);
    }
}
