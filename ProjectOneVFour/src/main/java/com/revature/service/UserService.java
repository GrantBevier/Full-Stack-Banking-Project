package com.revature.service;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	public List<User> getAllUsers();
	
	public List<User> getAllPendingApplications();
	
	//public User getUserByName(String name);
	
	public User getUserByID(int id);

	public boolean createUser(User newUser);
	
	boolean deleteUser(User p);
	
	//boolean updateUser(User p);

	//public boolean updateUser(User p, float balanceChange);
	
	//public boolean updateUserPhoneAndEmail(User p, String newPhoneNumber, String newEmailAddress);
	
	public boolean updateUserPhoneNumber(User p, String newPhoneNumber);
	
	public boolean updateUserEmailAddress(User p, String newEmailAddress);
	
	public boolean checkingAccountDeposit(User p, float balanceChange);
	
	public boolean savingsAccountDeposit(User p, float balanceChange);
	
	public boolean checkingAccountWithdrawal(User p, float balanceChange);
	
	public boolean savingsAccountWithdrawal(User p, float balanceChange);
	
	public boolean acceptUserApplication(int id);
	
	public boolean rejectUserApplication(int id);
}
