package com.revature.exceptions;

import com.revature.MainDriver;

public class UserNotExistsException extends Exception
{
	public UserNotExistsException()
	{
        System.out.print("User does not exist.\n");
        MainDriver.loggy.warn("UserNotExistsException");
    }
}
