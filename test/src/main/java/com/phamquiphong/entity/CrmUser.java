package com.phamquiphong.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String username;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
