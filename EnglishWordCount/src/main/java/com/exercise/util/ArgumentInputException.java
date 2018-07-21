package com.exercise.util;

public class ArgumentInputException extends Exception {

	private String defaultValue;

	public ArgumentInputException(String inputValue) {
		this.defaultValue = inputValue;
	}

	public String getArgumentIntegerInputException() {
		return defaultValue;
	}

}
