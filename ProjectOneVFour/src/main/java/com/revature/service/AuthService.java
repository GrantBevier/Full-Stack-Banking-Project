package com.revature.service;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserNotExistsException;

public interface AuthService
{
	public boolean authenticateUser(int id, String username, String password) throws InvalidCredentialsException, UserNotExistsException;
	
	public boolean authenticateEmployee(int id, String username, String password) throws InvalidCredentialsException, UserNotExistsException;
}
