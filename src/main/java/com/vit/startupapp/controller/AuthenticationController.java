package com.vit.startupapp.controller;

import com.vit.startupapp.controller.objects.AuthenticationRequest;
import com.vit.startupapp.controller.objects.AuthenticationResponse;
import com.vit.startupapp.service.UserDetailService;
import com.vit.startupapp.util.JwtUtil;
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

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserDetailService userDetailsService;

	@PostMapping( "/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		ArrayList<String> authorities=new ArrayList<String>();
		authorities.add("ROLE_ADMIN");
		authorities.add("ROLE_PM");

		return ResponseEntity.ok(new AuthenticationResponse(jwt, authorities, userDetails.getUsername()));
	}

}

