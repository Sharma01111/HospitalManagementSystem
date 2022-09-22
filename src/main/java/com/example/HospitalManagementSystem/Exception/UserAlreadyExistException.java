package com.example.HospitalManagementSystem.Exception;

public class UserAlreadyExistException extends RuntimeException {

	public UserAlreadyExistException(String message)
	{
		super(message);
	}
}