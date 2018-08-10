package com.exercise;

import com.exercise.controller.IOController;
import com.exercise.repository.WordCount;
import com.exercise.util.ArgumentInputException;
import com.exercise.util.Config;

public class Main {
	public static void main(String[] args) {
		Config config = Config.IOConfig(args);
		WordCount wordCount = WordCount.getEnglishWord(config);
		try {
			IOController.outputControl(config, wordCount);
		} catch (ArgumentInputException e) {
			e.printStackTrace();
		}

	}
}
