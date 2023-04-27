package com.app.reearth.reearth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.reearth.reearth.DTO.LoginDTO;
import com.app.reearth.reearth.DTO.UserDTO;
import com.app.reearth.reearth.Entity.Admin;
import com.app.reearth.reearth.Entity.Loginresponse;
import com.app.reearth.reearth.Exception.InvalidCredentialsException;
import com.app.reearth.reearth.Exception.UserAlreadyExistsException;
import com.app.reearth.reearth.Exception.UserNotFoundException;
import com.app.reearth.reearth.service.Userservice;

@RestController
@CrossOrigin
@RequestMapping("reearth/v1/")
public class Usercontroller {

	@Autowired
	Userservice userService;

	/**
	 * Method To Register User
	 * 
	 * @param userDTO
	 * @return username
	 */
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> saveUser(@Valid @RequestBody UserDTO userDTO) {
		Map<String, Object> response = new HashMap<>();

		try {
			String username = userService.addUser(userDTO);
			response.put("status", HttpStatus.OK.value());
			response.put("message", "User saved successfully with username: " + username);
			return ResponseEntity.ok(response);
		} catch (UserAlreadyExistsException e) {
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "User already exists with email " + userDTO.getEmail());
			return ResponseEntity.badRequest().body(response);
		} catch (MethodArgumentNotValidException e) {
			// Extract the error messages from the exception
			List<String> errorMessages = e.getBindingResult().getFieldErrors().stream()
					.map(error -> "Missing " + error.getField() + " field with value " + error.getRejectedValue())
					.collect(Collectors.toList());

			// Construct the error response
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "One or more fields are missing");
			response.put("errors", errorMessages);
			return ResponseEntity.badRequest().body(response);
		} catch (Exception ex) {
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", "An error occurred while saving user");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * Login User
	 * 
	 * @param loginDTO
	 * @return
	 */

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
		Map<String, Object> response = new HashMap<>();

		try {
			Loginresponse loginresponse = userService.loginUser(loginDTO);
			response.put("status", HttpStatus.OK.value());
			response.put("message", "User logged in successfully");
			return ResponseEntity.ok(response);
		} catch (UserNotFoundException ex) {
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "User not found with email " + loginDTO.getemail());
			return ResponseEntity.badRequest().body(response);
		} catch (InvalidCredentialsException ex) {
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "Invalid credentials" + " " + "Check your mail and password");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception ex) {
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "An error occurred while logging in");
			return ResponseEntity.badRequest().body(response);
		}
	}

	/**
	 * Admin login
	 * 
	 * @param admin
	 * @return
	 */

	@PostMapping("/admin")
	public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Admin admin) {
		Map<String, Object> response = new HashMap<>();

		try {
			String result = userService.adminLogin(admin);
			response.put("status", HttpStatus.OK.value());
			response.put("message", "Welcome, " + admin.getEmail() + "! " + result);
			return ResponseEntity.ok(response);
		} catch (InvalidCredentialsException e) {
			response.put("status", HttpStatus.UNAUTHORIZED.value());
			response.put("message", "Invalid email or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		} catch (Exception ex) {
			response.put("status", HttpStatus.BAD_REQUEST.value());
			response.put("message", "An error occurred while logging in");
			return ResponseEntity.badRequest().body(response);
		}
	}
}
