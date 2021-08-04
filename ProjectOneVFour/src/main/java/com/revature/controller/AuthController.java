package com.revature.controller;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserNotExistsException;

import io.javalin.http.Context;

public interface AuthController
{
	public void login(Context ctx) throws NumberFormatException, InvalidCredentialsException, UserNotExistsException;
	//public void loginTest(Context ctx) throws NumberFormatException, InvalidCredentialsException, UserNotExistsException;
}
