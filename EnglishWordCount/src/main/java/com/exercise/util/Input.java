package com.exercise.util;

import com.exercise.Main;

public class Input {
	private String inputFile;
	private String outputFile;

	public String getInputFile() {
		return inputFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public Input() {
		this(new Main().getInputControl(), new Main().getOutputControl());
	}

	public Input(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	public String getFilePath(String folderPath, String fileName) {
		String fullPath = folderPath + fileName;
		return fullPath;

	}

	public String getDBConnectName(String fileName) {
		return fileName;
	}

}
