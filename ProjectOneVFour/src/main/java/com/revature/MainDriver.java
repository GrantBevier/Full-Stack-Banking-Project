package com.revature;

import com.revature.controller.AuthController;
import com.revature.controller.AuthControllerImpl;
import com.revature.controller.UserController;
import com.revature.controller.UserControllerImpl;
import com.revature.controller.UserController;
import com.revature.controller.UserControllerImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

import io.javalin.Javalin;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//import java.util.logging.*;
import org.apache.log4j.Logger;

public class MainDriver
{
	public static final Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static int userID;
//	private static int userID;
//	
//	public static int getuserID()
//	{
//		return userID;
//	}

	private static AuthController authController = new AuthControllerImpl();
	private static UserController userController = new UserControllerImpl();
	
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		loggy.info("Program started.");
		
		Javalin app = Javalin.create(
				config -> {config.addStaticFiles("/public");
				}
			).start(9000);
		
		app.post("login", ctx -> authController.login(ctx));
		
		app.get("getAllUsers", ctx -> userController.getAllUsers(ctx));
		app.get("getAllPendingApplications", ctx -> userController.getAllPendingApplications(ctx));
		
		//app.post("updateUserPhoneAndEmail", ctx -> userController.updateUserPhoneAndEmail(ctx));
		app.post("updateUserPhoneNumber", ctx -> userController.updateUserPhoneNumber(ctx));
		app.post("updateUserEmailAddress", ctx -> userController.updateUserEmailAddress(ctx));
		app.post("checkingAccountDeposit", ctx -> userController.checkingAccountDeposit(ctx));
		app.post("savingsAccountDeposit", ctx -> userController.savingsAccountDeposit(ctx));
		app.post("checkingAccountWithdrawal", ctx -> userController.checkingAccountWithdrawal(ctx));
		app.post("savingsAccountWithdrawal", ctx -> userController.savingsAccountWithdrawal(ctx));
		
		app.post("acceptUserApplication", ctx -> userController.acceptUserApplication(ctx));
		app.post("rejectUserApplication", ctx -> userController.rejectUserApplication(ctx));
		
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
		{
		    Desktop.getDesktop().browse(new URI("http://localhost:9000/login.html"));
		}
	}
}
