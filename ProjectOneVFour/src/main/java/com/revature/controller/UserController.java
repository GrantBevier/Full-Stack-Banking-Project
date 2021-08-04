package com.revature.controller;

import io.javalin.http.Context;

public interface UserController {
	
	public void getAllUsers(Context ctx);
	
	public void getAllPendingApplications(Context ctx);
	
	//public void postUser(Context ctx);
	
	//void updateUser(Context ctx);
	
	//public void updateUserPhoneAndEmail(Context ctx);
	
	public void updateUserPhoneNumber(Context ctx);
	
	public void updateUserEmailAddress(Context ctx);
	
	public void checkingAccountDeposit(Context ctx);
	
	public void savingsAccountDeposit(Context ctx);
	
	public void checkingAccountWithdrawal(Context ctx);
	
	public void savingsAccountWithdrawal(Context ctx);
	
	//void deleteUserWithJSON(Context ctx);
	
	//void deleteUser(Context ctx);
	
	public void acceptUserApplication(Context ctx);
	
	public void rejectUserApplication(Context ctx);
}
