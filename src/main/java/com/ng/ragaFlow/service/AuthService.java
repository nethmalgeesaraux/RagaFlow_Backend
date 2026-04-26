package com.ng.ragaFlow.service;

import com.ng.ragaFlow.dto.request.RegisterUserRequest;
import com.ng.ragaFlow.dto.response.MessageResponse;

public interface AuthService {

    MessageResponse registerUser(RegisterUserRequest request);

}
