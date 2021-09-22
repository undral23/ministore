package edu.miu.waa.ministore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.waa.ministore.dto.AuthenticationRequest;
import edu.miu.waa.ministore.dto.AuthenticationResponse;
import edu.miu.waa.ministore.dto.UserRegisterDTO;
import edu.miu.waa.ministore.service.UserService;
import edu.miu.waa.ministore.service.MyUserDetails.LoginUserDetailsService;
import edu.miu.waa.ministore.util.JwtUtil;

@RestController
@CrossOrigin(origins = { "*" })
public class AuthentificationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private LoginUserDetailsService loginUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("!! INCORRECT USER NAME OR PASSWORD", e);
		}

		final UserDetails userDetails = loginUserDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> createUser(@RequestBody UserRegisterDTO userRegisterDTO) {

		boolean isUserCreated = userService.createUser(userRegisterDTO);
		if (isUserCreated) {
			UserDetails userDetails = loginUserDetailsService.loadUserByUsername(userRegisterDTO.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}
		return ResponseEntity.ok(new AuthenticationResponse(null));
	}
}
