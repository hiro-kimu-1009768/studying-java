package com.exercise.util;

public class ArgumentInputException extends Exception {

	private Config defaultValue;

	public ArgumentInputException(Config config) {
		this.defaultValue = config;
	}

	public Config getArgumentIntegerInputException() {
		return defaultValue;
	}

}
