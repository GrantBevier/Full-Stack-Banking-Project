package com.revature.controller;

import com.revature.MainDriver;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserNotExistsException;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;

import io.javalin.http.Context;

public class AuthControllerImpl implements AuthController
{	
	private AuthService authService = new AuthServiceImpl();

	@Override
	public void login(Context ctx) throws NumberFormatException, InvalidCredentialsException, UserNotExistsException
	//public void loginTest(Context ctx) throws NumberFormatException, InvalidCredentialsException, UserNotExistsException
	{
		System.out.println("Login has begun in AuthControllerImpl!");
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		//String id = ctx.formParam("userID");
		MainDriver.userID = Integer.parseInt(ctx.formParam("userID"));
		String employeeLogin = ctx.formParam("employeeLogin");
		
		try
		{
			if (employeeLogin == null) //user login
			{
				//if (authService.authenticateUser(Integer.parseInt(id), username, password))
				if (authService.authenticateUser(MainDriver.userID, username, password))
				{
					System.out.println("User login in AuthControllerImpl!");
					ctx.status(200);
					//ctx.redirect("view-user.html");
					ctx.redirect("user-view.html");
				}
				else
				{
					System.out.println("Failed login in AuthControllerImpl!");
					ctx.status(507);
					ctx.redirect("login.html");
				}
				//ctx.formParam(id)
				//if user doesn't exists you'd set it to 407 
			}
			else if (employeeLogin.equals("on")) //employee login
			{	
				//if (authService.authenticateEmployee(Integer.parseInt(id), username, password))
				if (authService.authenticateEmployee(MainDriver.userID, username, password))
				{
					System.out.println("Employee login in AuthControllerImpl!");
					ctx.status(200);
					ctx.redirect("employee-view.html");
				}
				else
				{
					System.out.println("Failed login in AuthControllerImpl!");
					ctx.status(507);
					ctx.redirect("login.html");
				}
			}
			else
			{
				System.out.println("Failed login in AuthControllerImpl!");
				ctx.status(507);
				ctx.redirect("login.html");
			}
		}
		catch (NumberFormatException e)
		{
			MainDriver.loggy.warn("NumberFormatException thrown in AuthControllerImpl");
			ctx.redirect("login.html");
		}
		catch (Exception e)
		{
			MainDriver.loggy.warn("Exception thrown in AuthControllerImpl");
			ctx.redirect("login.html");
		}
		
		
//		if (authService.authenticateUser(Integer.parseInt(id), username, password))
//		{
//			System.out.println(employeeLogin);
//			//System.out.println(employeeLoginBoolean);
//			//if (employeeLogin.equals("null"))
//			if (employeeLogin == null)
//			{
//				ctx.status(200);
//				ctx.redirect("view-user.html");
//			}
//			else if (employeeLogin.equals("on"))
//			{
//				ctx.status(200);
//				ctx.redirect("view-users.html");
//			}
//			//ctx.formParam(id)
//			//if user doesn't exists you'd set it to 407 
//		}
//		else
//		{	
//			ctx.status(507);
//			ctx.redirect("login.html");
//		}
		//System.out.println(username);
		//System.out.println(password);
	}
}
