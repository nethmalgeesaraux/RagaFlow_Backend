package com.ng.ragaFlow.repository;

import com.ng.ragaFlow.dto.request.LoginUserRequest;
import com.ng.ragaFlow.dto.response.AppUserResponse;
import com.ng.ragaFlow.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Boolean existsByEmail(String email);


    Optional<AppUser> findByEmail(String email);






}
