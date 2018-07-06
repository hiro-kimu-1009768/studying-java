package com.exercise;

import com.exercise.repository.RepositoryConsole;
import com.exercise.repository.RepositoryJson;

public class Main {
	public static void main(String[] args) {
		RepositoryConsole repositoryConsole = new RepositoryConsole();
		repositoryConsole.getEnglishWordCosole();

		RepositoryJson repositoryJson = new RepositoryJson();
		repositoryJson.getAllToJson();
	}
}
