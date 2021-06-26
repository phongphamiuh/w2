package com.se.dao;

import com.se.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
