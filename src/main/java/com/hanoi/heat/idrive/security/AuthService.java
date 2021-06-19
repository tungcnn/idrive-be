package com.hanoi.heat.idrive.security;

import com.hanoi.heat.idrive.dto.RegisterRequest;
import com.hanoi.heat.idrive.model.Role;
import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFullName(registerRequest.getFullName());
        user.setCreated(Instant.now());
        Role appRole = new Role();
        appRole.setId(1L);
        user.setRole(appRole);

        userRepo.save(user);
    }
}
