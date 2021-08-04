package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserServiceImpl implements UserService
{
	UserDAO uDAO = new UserDAOImpl();
	
	@Override
	public List<User> getAllUsers()
	{
		System.out.println("getAllUsers() called in UserServiceImpl");
		List<User> UserList = uDAO.selectAllUsers();
		
		// TODO Auto-generated method stub
		return UserList;
	}
	
	@Override
	public List<User> getAllPendingApplications()
	{
		System.out.println("getAllPendingApplications() called in UserServiceImpl");
		List<User> UserList = uDAO.selectAllPendingApplications();
		
		// TODO Auto-generated method stub
		return UserList;
	}

	@Override
	public boolean createUser(User newUser)
	{
		return uDAO.insertUser(newUser);
	}

	@Override
	public boolean deleteUser(User p) 
	{
		return uDAO.deleteUser(p);
	}

//	@Override
//	public boolean updateUser(User p) {
//		// TODO Auto-generated method stub
//		return uDAO.updateUser(p);
//	}

//	@Override
//	public User getUserByName(String name) {
//
//		return uDAO.selectUserByName(name);
//	}

//	@Override
//	public boolean updateUser(User p, boolean rings) {
//		// TODO Auto-generated method stub
//			
//		p.setRings(rings);
//		return uDAO.updateUser(p);
//		
//	}

	@Override
	public User getUserByID(int id)
	{
		System.out.println("getUserByID() called in UserServiceImpl");
		return uDAO.selectUserById(id).get(0);
	}

//	@Override
//	public boolean updateUser(User p, float balanceChange)
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean updateUserPhoneAndEmail(User p, String newPhoneNumber, String newEmailAddress)
//	{
//		System.out.println("updateUserPhoneAndEmail() called in UserServiceImpl with " + newPhoneNumber + " and " + newEmailAddress + " as arguments");
//		uDAO.updateUserPhoneAndEmail(newPhoneNumber, newEmailAddress, p);
//		return false;
//	}
	
	@Override
	public boolean updateUserPhoneNumber(User p, String newPhoneNumber)
	{
		System.out.println("updateUserPhoneNumber() called in UserServiceImpl with " + newPhoneNumber + " as an argument");
		uDAO.updateUserPhoneNumber(newPhoneNumber, p);
		return false;
	}
	
	@Override
	public boolean updateUserEmailAddress(User p, String newEmailAddress)
	{
		System.out.println("updateUserEmailAddress() called in UserServiceImpl with " + newEmailAddress + " as an argument");
		uDAO.updateUserEmailAddress(newEmailAddress, p);
		return false;
	}
	
	@Override
	public boolean checkingAccountDeposit(User p, float balanceChange)
	{
		System.out.println("checkingAccountDeposit() called in UserServiceImpl for user " + p + "for $" + balanceChange);
		//p.setCheckingAccountBalance(p.getCheckingAccountBalance() + balanceChange); //as of 1:42 p.m. 7-15-2021, I WAS NOT USING THE DAO HERE.
		uDAO.updateUserCheckingBalance(balanceChange, true, p);
		return false;
	}

	@Override
	public boolean savingsAccountDeposit(User p, float balanceChange)
	{
		System.out.println("savingsAccountDeposit() called in UserServiceImpl");
		uDAO.updateUserSavingsBalance(balanceChange, true, p);
		return false;
	}

	@Override
	public boolean checkingAccountWithdrawal(User p, float balanceChange)
	{
		System.out.println("checkingAccountWithdrawal() called in UserServiceImpl");
		uDAO.updateUserCheckingBalance(balanceChange, false, p);
		return false;
	}

	@Override
	public boolean savingsAccountWithdrawal(User p, float balanceChange)
	{
		System.out.println("savingsAccountWithdrawal() called in UserServiceImpl");
		uDAO.updateUserSavingsBalance(balanceChange, false, p);
		return false;
	}
	
	@Override
	public boolean acceptUserApplication(int applicationID)
	{
		System.out.println("acceptUserApplication() called in UserServiceImpl");
		uDAO.acceptUserApplication(applicationID);
		return false;
	}
	
	@Override
	public boolean rejectUserApplication(int applicationID)
	{
		System.out.println("rejectUserApplication() called in UserServiceImpl");
		uDAO.removeUserApplication(applicationID);
		return false;
	}
}
