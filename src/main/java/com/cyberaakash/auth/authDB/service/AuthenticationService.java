package com.cyberaakash.auth.authDB.service;

import com.cyberaakash.auth.authDB.dto.SignUpRequest;
import com.cyberaakash.auth.authDB.entity.User;

public interface AuthenticationService  {
    User signup(SignUpRequest signUpRequest);
}