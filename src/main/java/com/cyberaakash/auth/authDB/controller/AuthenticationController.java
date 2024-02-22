package com.cyberaakash.auth.authDB.controller;

import com.cyberaakash.auth.authDB.dto.JwtAuthenticationResponse;
import com.cyberaakash.auth.authDB.dto.RefreshTokenRequest;
import com.cyberaakash.auth.authDB.dto.SignInRequest;
import com.cyberaakash.auth.authDB.dto.SignUpRequest;
import com.cyberaakash.auth.authDB.entity.User;
import com.cyberaakash.auth.authDB.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private  AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return new ResponseEntity<>(authenticationService.signup(signUpRequest), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) {
        return new ResponseEntity<>(authenticationService.signin(signInRequest), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenRequest), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> hiAdmin() {
//        log.info(authentication.getName());
        return new ResponseEntity<>("Hello Admin", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> hiUser() {
        return new ResponseEntity<>("Hello User", HttpStatus.OK);
    }
}
