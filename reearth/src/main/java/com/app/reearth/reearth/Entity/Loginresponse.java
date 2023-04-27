package com.app.reearth.reearth.Entity;

public class Loginresponse {

	String message;
	Boolean status;

	public Loginresponse(String message, Boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Loginresponse [message=" + message + ", status=" + status + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
