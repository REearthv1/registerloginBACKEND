package com.app.reearth.reearth.DTO;

import javax.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull
	private String email;
	@NotNull
	private String password;

	public LoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public LoginDTO() {

	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
