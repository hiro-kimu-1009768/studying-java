package com.exercise.controller;

import com.exercise.util.ArgumentInputException;

public interface IOController {

	String getInputFullPath();

	String inputControl(String inputControl);

	void outputControl(String outputControl) throws ArgumentInputException;
}