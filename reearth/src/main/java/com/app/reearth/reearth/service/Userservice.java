package com.app.reearth.reearth.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.app.reearth.reearth.DTO.LoginDTO;
import com.app.reearth.reearth.DTO.UserDTO;
import com.app.reearth.reearth.Entity.Admin;
import com.app.reearth.reearth.Entity.Loginresponse;
import com.app.reearth.reearth.Exception.InvalidCredentialsException;
import com.app.reearth.reearth.Exception.UserAlreadyExistsException;

public interface Userservice {

	String addUser(UserDTO userDTO) throws UserAlreadyExistsException, MethodArgumentNotValidException;

	Loginresponse loginUser(LoginDTO loginDTO) throws InvalidCredentialsException;

	String adminLogin(Admin admin) throws InvalidCredentialsException;;

}
