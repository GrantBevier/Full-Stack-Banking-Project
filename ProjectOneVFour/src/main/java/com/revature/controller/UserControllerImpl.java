package com.revature.controller;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.jetty.util.ajax.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.MainDriver;
import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

import io.javalin.http.Context;

public class UserControllerImpl implements UserController
{
	private UserService userService= new UserServiceImpl();
	
	@Override
	public void getAllUsers(Context ctx)
	{
		System.out.println("getAllUsers() called from UserControllerImpl");
		//ctx.status(418);
		ctx.status(200);
		ctx.json(userService.getAllUsers());
	}
	
	@Override
	public void getAllPendingApplications(Context ctx)
	{
		System.out.println("getAllPendingApplications() called from UserControllerImpl");
		//ctx.status(418);
		ctx.status(200);
		ctx.json(userService.getAllPendingApplications());
	}

//	@Override
//	public void postUser(Context ctx)
//	{
//		System.out.println("User creation started.");
//		//int id = ctx.formParam(Integer.parseInt("userID"));
//		String id = ctx.formParam("userID");
//		String firstName = ctx.formParam("firstName");
//		String lastName = ctx.formParam("lastName");
//		String emailAddress = ctx.formParam("emailAddress");
//		String phoneNumber = ctx.formParam("phoneNumber");
//		String username = ctx.formParam("username");
//		String password = ctx.formParam("password");
//		String checkingAccountNumber = ctx.formParam("checkingAccountNumber");
//		String checkingRoutingNumber = ctx.formParam("checkingRoutingNumber");
//		//float checkingAccountBalance = ctx.formParam("checkingAccountBalance");
//		String checkingAccountBalance = ctx.formParam("checkingAccountBalance");
//		String savingsAccountNumber = ctx.formParam("savingsAccountNumber");
//		String savingsRoutingNumber = ctx.formParam("savingsRoutingNumber");
//		//float savingsAccountBalance = ctx.formParam("savingsAccountBalance");
//		String savingsAccountBalance = ctx.formParam("savingsAccountBalance");
//		
//		//User newUser = new User(0, userName, description, rings, 0);
//		//User newUser = new User(id, firstName, lastName, emailAddress, phoneNumber, checkingAccountNumber, checkingRoutingNumber, 
//				//checkingAccountBalance, savingsAccountNumber, savingsRoutingNumber, savingsAccountBalance);
//		User newUser = new User(Integer.parseInt("userID"), firstName, lastName, emailAddress, phoneNumber, username, password, checkingAccountNumber,
//				checkingRoutingNumber, Float.parseFloat("checkingAccountBalance"), savingsAccountNumber, savingsRoutingNumber, Float.parseFloat("savingsAccountBalance"));		
//		System.out.println(newUser);
//		if (userService.createUser(newUser))
//		{
//			//ctx.status(201);
//			ctx.status(200);
//			ctx.redirect("http://localhost:9000/view-users.html");
//		}
//		else
//		{
//			System.out.println("User not created.");
//			ctx.status(506);
//		}
//	}

//	@Override
//	public void updateUser(Context ctx)
//	{	
////		User p = (User) JSON.parse(ctx.body()); //we're not sending just parameters, we're sending a JSON representation of our User
//								//we're using Jackson, to demarshal our JSON into a Java object. 	
//		System.out.println((HashMap<String, String>) JSON.parse(ctx.body()));
//		
//		ObjectMapper om = new ObjectMapper();
//		
//		User p;
//		try
//		{
//			p = om.readValue(ctx.body(), User.class); //json information 
//			//boolean rings = p.isRings();
//			float balanceChange = p.getCheckingAccountBalance();
//		
//			p = userService.getUserByID(p.getId()); //full database object 
//				
//			userService.updateUser(p, balanceChange); //change the database objects
//			
//			ctx.status(999);
//		}
//		catch (JsonProcessingException e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
//	@Override
//	public void updateUserPhoneAndEmail(Context ctx)
//	{	
//		System.out.println("updateUserPhoneAndEmail() called in UserControllerImpl");
//		String newPhoneNumber = ctx.formParam("phoneNumber");
//		String newEmailAddress = ctx.formParam("emailAddress");
//		
//		User p;
//		try
//			{
//			
//			p = userService.getUserByID(MainDriver.userID);
//			
//			userService.updateUserPhoneAndEmail(p, newPhoneNumber, newEmailAddress);
//			
//			ctx.status(200);
//			ctx.redirect("user-view.html");
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			ctx.redirect("user-view.html");
//		}
//	}
	
	@Override
	public void updateUserPhoneNumber(Context ctx)
	{	
		String newPhoneNumber = ctx.formParam("phoneNumber");
		System.out.println("updateUserPhoneNumber() called in UserControllerImpl with " +  newPhoneNumber + " as an argument");
		
		User p;
		try
			{
			p = userService.getUserByID(MainDriver.userID);
			
			userService.updateUserPhoneNumber(p, newPhoneNumber);
			
			ctx.status(200);
			ctx.redirect("user-view.html");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	@Override
	public void updateUserEmailAddress(Context ctx)
	{	
		String newEmailAddress = ctx.formParam("emailAddress");
		System.out.println("updateUserEmailAddress() called in UserControllerImpl with " +  newEmailAddress + " as an argument");
		
		User p;
		try
			{
			p = userService.getUserByID(MainDriver.userID);
			
			userService.updateUserEmailAddress(p, newEmailAddress);
			
			ctx.status(200);
			ctx.redirect("user-view.html");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	public void checkingAccountDeposit(Context ctx)
	{
		System.out.println("checkingAccountDeposit() called in UserControllerImpl");
		//		User p = (User) JSON.parse(ctx.body()); //we're not sending just parameters, we're sending a JSON representation of our User
				//we're using Jackson, to demarshal our JSON into a Java object. 	
		//System.out.println((HashMap<String, String>) JSON.parse(ctx.body()));
		
		//ObjectMapper om = new ObjectMapper();
		
		//String id = ctx.formParam("id");
		//String checkingAccountBalance = ctx.formParam("checkingAccountBalance");
		String checkingDepositAmount = ctx.formParam("checkingDepositAmount");
		//System.out.println(id);
		//System.out.println(checkingAccountBalance);
		System.out.println(checkingDepositAmount);
		
		User p;
		try
		{
			//System.out.println(ctx.body());
			//System.out.println(om.readValue(ctx.body(), User.class));
			//p = om.readValue(ctx.body(), User.class); //json information
			//boolean rings = p.isRings();
			
			//p = userService.getUserByID(p.getId()); //full database object 
			//p = userService.getUserByID(Integer.parseInt(id)); //full database object
			
			//p = userService.getUserByID(1); //full database object
			
			p = userService.getUserByID(MainDriver.userID); //full database object
			
			userService.checkingAccountDeposit(p, Float.parseFloat(checkingDepositAmount));
			
			//ctx.status(999);
			ctx.status(200);
			System.out.println("Checking deposit made in UserControllerImpl!");
			ctx.redirect("user-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	public void savingsAccountDeposit(Context ctx)
	{
		System.out.println("savingsAccountDeposit() called in UserControllerImpl");
		String savingsDepositAmount = ctx.formParam("savingsDepositAmount");
		System.out.println(savingsDepositAmount);
		User p;
		try
		{	
			p = userService.getUserByID(MainDriver.userID);
			
			userService.savingsAccountDeposit(p, Float.parseFloat(savingsDepositAmount));
			
			ctx.status(200);
			System.out.println("Savings deposit made in UserControllerImpl!");
			ctx.redirect("user-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	public void checkingAccountWithdrawal(Context ctx)
	{
		System.out.println("checkingAccountWithdrawal() called in UserControllerImpl");
		String checkingWithdrawalAmount = ctx.formParam("checkingWithdrawalAmount");
		System.out.println(checkingWithdrawalAmount);
		User p;
		try
		{	
			p = userService.getUserByID(MainDriver.userID);
			
			userService.checkingAccountWithdrawal(p, Float.parseFloat(checkingWithdrawalAmount));
			
			ctx.status(200);
			System.out.println("Checking withdrawal made in UserControllerImpl!");
			ctx.redirect("user-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	public void savingsAccountWithdrawal(Context ctx)
	{
		System.out.println("savingsAccountWithdrawal() called in UserControllerImpl");
		String savingsWithdrawalAmount = ctx.formParam("savingsWithdrawalAmount");
		System.out.println(savingsWithdrawalAmount);
		User p;
		try
		{	
			p = userService.getUserByID(MainDriver.userID);
			
			userService.savingsAccountWithdrawal(p, Float.parseFloat(savingsWithdrawalAmount));
			
			ctx.status(200);
			System.out.println("Savings withdrawal made in UserControllerImpl!");
			ctx.redirect("user-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("user-view.html");
		}
	}
	
	public void acceptUserApplication(Context ctx)
	{
		System.out.println("acceptUserApplication() called in UserControllerImpl");
		//String id = ctx.formParam("id");
		String id = ctx.formParam("acceptApplicationID");
		System.out.println(id);
		//User p;
		try
		{
			//p = userService.acceptUserApplication(user);
			
			//userService.savingsAccountWithdrawal(p, Float.parseFloat(savingsWithdrawalAmount));
			
			userService.acceptUserApplication(Integer.parseInt(id));
			
			ctx.status(200);
			System.out.println("Application accepted in UserControllerImpl!");
			ctx.redirect("employee-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("employee-view.html");
		}
	}
	
	public void rejectUserApplication(Context ctx)
	{
		System.out.println("rejectUserApplication() called in UserControllerImpl");
		String id = ctx.formParam("id");
		System.out.println(id);
		//User p;
		try
		{
			//p = userService.acceptUserApplication(user);
			
			//userService.savingsAccountWithdrawal(p, Float.parseFloat(savingsWithdrawalAmount));
			
			userService.rejectUserApplication(Integer.parseInt(id));
			
			ctx.status(200);
			System.out.println("Application rejected in UserControllerImpl!");
			ctx.redirect("employee-view.html");
		}
		catch (/*JsonProcessingException*/Exception e) 
		{
			e.printStackTrace();
			ctx.redirect("employee-view.html");
		}
	}
}
