package com.revature.dao;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.InvalidInputException;
import com.revature.models.Employee;
import com.revature.models.User;

public interface UserDAO {	
	//Create
	public boolean insertUser(User f);
	public boolean createUserApplication(User f);
	//public boolean AcceptUserApplication(User f);
	public boolean acceptUserApplication(int id);
	//public boolean LogTransaction(User f, String accountType, float balanceChange);
	
	//Read
	public List<User> selectUserById(int id);
	public List<User> selectUserByAllCredentials(String username, String password, int id) throws InvalidCredentialsException;
	public List<User> selectUsersByFirstName(String firstName);
	public List<User> selectAllUsers();
	public List<Employee> selectEmployee(String username, String password, int id) throws InvalidCredentialsException;
	public List<User> selectAllPendingApplications();
	public List<User> selectApplicationById(int id);
	
	//Update 
	public void updateUser(User f);
	//public void updateUserPhoneAndEmail(String newPhoneNumber, String newEmailAddress, User user);
	public void updateUserPhoneNumber(String newPhoneNumber, User p);
	public void updateUserEmailAddress(String newEmailAddress, User p);
	public void updateUserCheckingBalance(float balanceChange, boolean depositing, User f)/*, Scanner scanner, UserDAO userDao, File transactionLog) throws InvalidInputException*/;
	public void updateUserSavingsBalance(float balanceChange, boolean depositing, User f);
	
	//Delete
	//public void deleteUser(User f);
	public boolean deleteUser(User f);
	//public boolean RemoveUserApplication(User f);
	public boolean removeUserApplication(int id);
}
