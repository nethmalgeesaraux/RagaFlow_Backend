package com.ng.ragaFlow.service;

import com.ng.ragaFlow.dto.request.LoginUserRequest;
import com.ng.ragaFlow.dto.request.RegisterUserRequest;
import com.ng.ragaFlow.dto.response.AppUserResponse;
import com.ng.ragaFlow.dto.response.MessageResponse;

public interface AuthService {

    MessageResponse registerUser(RegisterUserRequest request);

    AppUserResponse loginUser(LoginUserRequest request);

}
