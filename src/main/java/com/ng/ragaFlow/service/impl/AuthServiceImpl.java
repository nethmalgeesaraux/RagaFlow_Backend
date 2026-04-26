package com.ng.ragaFlow.service.impl;

import com.ng.ragaFlow.dto.request.RegisterUserRequest;
import com.ng.ragaFlow.dto.response.MessageResponse;
import com.ng.ragaFlow.entity.AppUser;
import com.ng.ragaFlow.exception.EmailAlreadyExistsException;
import com.ng.ragaFlow.repository.AppUserRepository;
import com.ng.ragaFlow.service.AuthService;
import com.ng.ragaFlow.service.EmailService;
import com.ng.ragaFlow.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    @Override
    public MessageResponse registerUser(RegisterUserRequest request) {
        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String tempPassword = generateTemporaryPassword();
        AppUser appUser = new AppUser();
        appUser.setName(request.getName());
        appUser.setEmail(request.getEmail());
        appUser.setPassword(passwordEncoder.encode(tempPassword));
        appUser.setRole(request.getRole() != null ? request.getRole() : "USER");

        appUserRepository.save(appUser);
        emailService.sendWelcomeEmail(appUser.getEmail(), appUser.getName(), tempPassword);

        return new MessageResponse("Account created successfully. A temporary password has been sent to your email.");

    }

    private String generateTemporaryPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$#";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

}
