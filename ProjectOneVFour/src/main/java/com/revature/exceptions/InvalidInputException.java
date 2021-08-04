package com.revature.exceptions;

import com.revature.MainDriver;

public class InvalidInputException extends Exception
{
	public InvalidInputException()
	{
        System.out.print("Input invalid.\n");
        MainDriver.loggy.warn("InvalidInputException");
    }
}
