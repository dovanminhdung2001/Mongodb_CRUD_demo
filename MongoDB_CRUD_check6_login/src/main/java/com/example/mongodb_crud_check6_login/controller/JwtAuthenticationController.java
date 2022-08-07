package com.example.mongodb_crud_check6_login.controller;

import java.util.Objects;

import com.example.mongodb_crud_check6_login.config.JwtTokenUtil;
import com.example.mongodb_crud_check6_login.model.CustomUser;
import com.example.mongodb_crud_check6_login.model.JwtRequest;
import com.example.mongodb_crud_check6_login.model.JwtResponse;
import com.example.mongodb_crud_check6_login.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private CustomUserService customUserService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		CustomUser user = customUserService.findByEMail(authenticationRequest.getUsername());

		if(user == null)
			return ResponseEntity.badRequest().body("email not found");

		if (! user.getPassword().equals(authenticationRequest.getPassword()))
			return ResponseEntity.badRequest().body("password Incorrect");

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

//	private void authenticate(String username, String password) throws Exception {
//		Objects.requireNonNull(username);
//		Objects.requireNonNull(password);
//
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
}
