package com.safesync.security.restcontrollers;

import com.safesync.security.Dto.AuthenticationRequest;
import com.safesync.security.Dto.AuthenticationResponse;
import com.safesync.security.entities.User;
import com.safesync.security.repository.UserRepository;
import com.safesync.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/safesync/secure")
public class SecurityController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest request)
	{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
					);
		}
		catch(Exception ex)
		{

		}
		
		String token = jwtUtil.generateToken(request.getUserName());
		
		User user = userRepository.findByUserName(request.getUserName());
		
		AuthenticationResponse response = AuthenticationResponse.builder()
										 .user(user)
										 .token(token)
										 .status(HttpStatus.OK)
										 .build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		user = userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
