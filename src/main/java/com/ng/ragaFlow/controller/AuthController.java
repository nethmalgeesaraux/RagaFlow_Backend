package com.ng.ragaFlow.controller;

import com.ng.ragaFlow.dto.request.LoginUserRequest;
import com.ng.ragaFlow.dto.request.RegisterUserRequest;
import com.ng.ragaFlow.dto.response.AppUserResponse;
import com.ng.ragaFlow.dto.response.MessageResponse;
import com.ng.ragaFlow.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registerUser")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        MessageResponse response = authService.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/loing")
    public ResponseEntity<AppUserResponse> loginUser(@Valid @RequestBody LoginUserRequest request){
        AppUserResponse response = authService.loginUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
