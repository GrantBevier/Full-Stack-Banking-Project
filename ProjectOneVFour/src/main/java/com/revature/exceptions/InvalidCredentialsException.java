package com.revature.exceptions;

import com.revature.MainDriver;

public class InvalidCredentialsException extends Exception
{
	public InvalidCredentialsException()
	{
        System.out.print("Credential combination invalid.\n");
        MainDriver.loggy.warn("InvalidCredentialsException");
    }
}