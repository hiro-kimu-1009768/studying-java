package com.exercise;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.exercise.controller.IOControllerImpl;
import com.exercise.util.ArgumentInputException;

public class Main {
	private static String inputControl;
	private static String outputControl;

	public static String getInputControl() {
		return inputControl;
	}

	public static String getOutputControl() {
		return outputControl;
	}

	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("i", true, "inputControl");
		options.addOption("o", true, "outputControl");

		CommandLineParser parser = new DefaultParser();
		CommandLine commandLine;

		try {
			commandLine = parser.parse(options, args);
		} catch (ParseException e) {
			System.err.println("引数解析エラー");
			return;
		}

		if (commandLine.hasOption("i")) {
			inputControl = commandLine.getOptionValue("i");
		}

		if (commandLine.hasOption("o")) {
			outputControl = commandLine.getOptionValue("o");
		}
		new IOControllerImpl().inputControl(inputControl);
		try {
			new IOControllerImpl().outputControl(outputControl);
		} catch (ArgumentInputException e) {
			e.printStackTrace();
		}

	}
}
