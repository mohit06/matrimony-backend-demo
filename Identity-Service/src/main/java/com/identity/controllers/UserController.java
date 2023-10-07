package com.identity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.identity.entities.AuthRequest;
import com.identity.entities.UserInfo;
import com.identity.jwt.JwtService;
import com.identity.services.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserInfoService uiService;

	@Autowired
	JwtService jwtService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String registerUser(@RequestBody UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		return uiService.register(userInfo);
	}

	@PostMapping("/getToken")
	public String getToken(@RequestBody AuthRequest authRequest) {
		System.out.println("req -> "+authRequest.toString());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}
	
	@GetMapping("/welcome")
    public String hello() {
		return "Hello";
	}
	

}
