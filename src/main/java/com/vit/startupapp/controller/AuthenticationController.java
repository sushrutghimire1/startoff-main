package com.vit.startupapp.controller;

import com.vit.startupapp.controller.objects.AuthenticationRequest;
import com.vit.startupapp.controller.objects.AuthenticationResponse;
import com.vit.startupapp.repository.ClientRegistrationRepository;
import com.vit.startupapp.repository.entity.ClientEntity;
import com.vit.startupapp.service.ClientRegistrationService;
import com.vit.startupapp.service.UserDetailService;
import com.vit.startupapp.helperutils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/auth")
class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final UserDetailService userDetailsService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil, UserDetailService userDetailsService, ClientRegistrationRepository clientRegistrationRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }


    @PostMapping("/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        if (!userDetails.getUsername().equals(authenticationRequest.getUsername()) &&
                !userDetails.getPassword().equals(authenticationRequest.getPassword()))
            throw new Exception("Incorrect username or password");

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        ArrayList<String> authorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(user -> authorities.add(user.getAuthority()));

        ClientEntity clientEntity = this.clientRegistrationRepository.findClientByUsername(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, authorities, clientEntity.getId()));
    }

}

