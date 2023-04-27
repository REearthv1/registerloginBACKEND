package com.app.reearth.reearth.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "userid", length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	@Column(name = "firstname", length = 255)

	private String firstname;

	@Column(name = "lastname", length = 255)

	private String lastname;

	@Column(name = "email", length = 255)

	private String email;

	@Column(name = "city", length = 255)

	private String city;

	@Column(name = "state", length = 255)

	private String state;

	@Column(name = "pincode", length = 255)

	private String pincode;

	@Column(name = "password", length = 255)

	private String password;

	@Column(name = "mobilenumber", length = 255)

	private String mobilenumber;

	@Column(name = "username", length = 255)

	private String username;

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(int userid, String city, String email, String firstname, String lastname, String mobilenumber,
			String password, String pincode, String state, String username) {
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.username = username;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", password=" + password
				+ ", mobilenumber=" + mobilenumber + ", username=" + username + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}