package com.app.reearth.reearth.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.reearth.reearth.DTO.LoginDTO;
import com.app.reearth.reearth.DTO.UserDTO;
import com.app.reearth.reearth.Entity.Admin;
import com.app.reearth.reearth.Entity.Loginresponse;
import com.app.reearth.reearth.Entity.User;
import com.app.reearth.reearth.Exception.InvalidCredentialsException;
import com.app.reearth.reearth.Exception.UserAlreadyExistsException;
import com.app.reearth.reearth.Exception.UserNotFoundException;
import com.app.reearth.reearth.Repostiory.UserRepo;
import com.app.reearth.reearth.service.Userservice;

@Service

public class Userimpl implements Userservice {

	@Autowired
	UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override

	public String addUser(UserDTO userDTO) throws UserAlreadyExistsException {
		// Check if user with the same email already exists in data source
		if (userRepo.existsByEmail(userDTO.getEmail())) {
			throw new UserAlreadyExistsException("User already exists with email " + userDTO.getEmail());
		}

		// Create a new user entity and save it to the data source
		User user = new User(userDTO.getUserid(), userDTO.getCity(), userDTO.getEmail(), userDTO.getFirstname(),
				userDTO.getLastname(), userDTO.getMobilenumber(), this.passwordEncoder.encode(userDTO.getPassword()),
				userDTO.getPincode(), userDTO.getState(), userDTO.getUsername());

		userRepo.save(user);

		return user.getUsername();
	}

	/*
	 * Method for user login
	 */
	public Loginresponse loginUser(LoginDTO loginDTO) throws InvalidCredentialsException {
		User user = userRepo.findByEmail(loginDTO.getemail());
		if (user == null) {
			throw new UserNotFoundException("User not found with email " + loginDTO.getemail());
		}
		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			throw new InvalidCredentialsException("Invalid credentials");
		}
		return new Loginresponse("Login Success", true);
	}

	/*
	 * method for admin login
	 */
	public String adminLogin(Admin admin) throws InvalidCredentialsException {
		if (admin.getEmail() == null || admin.getPassword() == null) {
			throw new InvalidCredentialsException("Email or password is missing");
		}
		if (admin.getEmail().equals("admin@gmail.com") && admin.getPassword().equals("password123")) {
			return "login success";
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}

	}

}
