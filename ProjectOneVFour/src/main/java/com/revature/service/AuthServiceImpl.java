package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserNotExistsException;
import com.revature.models.Employee;
import com.revature.models.User;

public class AuthServiceImpl implements AuthService {
	
	UserDAO uDao = new UserDAOImpl();

	@Override
	public boolean authenticateUser(int id, String username, String password) throws InvalidCredentialsException, UserNotExistsException
	{
		System.out.println("authenticateUser() called in AuthServiceImpl!");
		try
		{
			//User u = (User) uDao.selectUserByAllCredentials(username, password, id);
			List<User> uList = uDao.selectUserByAllCredentials(username, password, id);
			User u = uList.get(0);
			
			//checking if user exists with that username
			if (u == null)
			{
				return false;
			}
			else
			{
				//checking if that user password matches. 
				if (password.equals(u.getPassword()))
				{
					return true;
				}
			}
		}
//		catch (UserNotExistsException e)
//		{
//			e.printStackTrace();
//		}
		catch (IndexOutOfBoundsException e)
		{
			//e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			//e.printStackTrace();
		}
		catch (InvalidCredentialsException e)
		{
			//e.printStackTrace();
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean authenticateEmployee(int id, String username, String password) throws InvalidCredentialsException, UserNotExistsException
	{
		System.out.println("authenticateEmployee() called in AuthServiceImpl!");
		try
		{
			//User u = (User) uDao.selectUserByAllCredentials(username, password, id);
			List<Employee> eList = uDao.selectEmployee(username, password, id);
			Employee e = eList.get(0);
			
			//checking if user exists with that username
			if (e == null)
			{
				return false;
			}
			else
			{
				//checking if that user password matches. 
				if (password.equals(e.getPassword()))
				{
					return true;
				}
			}
		}
//		catch (UserNotExistsException e)
//		{
//			e.printStackTrace();
//		}
		catch (IndexOutOfBoundsException e)
		{
			//e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (InvalidCredentialsException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
