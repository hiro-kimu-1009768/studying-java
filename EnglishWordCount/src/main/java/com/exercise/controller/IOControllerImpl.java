package com.exercise.controller;

import com.exercise.repository.RepositoryConsole;
import com.exercise.repository.RepositoryDBClient;
import com.exercise.repository.RepositoryJson;
import com.exercise.util.ArgumentInputException;
import com.exercise.util.Input;

public class IOControllerImpl implements IOController {
	private static final String FOLDER_PATH = "src/main/resources/"; //フォルダ
	private static final String DEFAULT_INPUT_PATH = "sample.txt";

	private static String inputFullPath;

	@Override
	public String getInputFullPath() {
		return inputFullPath;
	}

	@Override
	public String inputControl(String inputControl) {
		Input input = new Input();
		if (inputControl == null) {
			inputFullPath = input.getFilePath(FOLDER_PATH, DEFAULT_INPUT_PATH);
		} else if (inputControl.endsWith(".txt")) {
			inputFullPath = input.getFilePath(FOLDER_PATH, inputControl);
		} else {
			inputFullPath = input.getFilePath(FOLDER_PATH, DEFAULT_INPUT_PATH);
		}
		return inputFullPath;
	}

	@Override
	public void outputControl(String outputControl) throws ArgumentInputException {
		if (outputControl == null) {
			//コンソール出力処理
			RepositoryConsole repositoryConsole = new RepositoryConsole();
			repositoryConsole.getEnglishWordConsole();

		} else {
			String fileName = outputControl.split("=")[1];
			if (outputControl.split("=")[0].equals("json")) {
				//jsonの出力処理
				System.out.println("JSONに出力します");
				RepositoryJson repositoryJson = new RepositoryJson();
				repositoryJson.getAllToJson(FOLDER_PATH, fileName);
				System.out.println("JSONへの出力が完了しました");

			} else if (outputControl.split("=")[0].equals("H2")) {
				//DBの登録処理
				System.out.println("DBに登録します");
				RepositoryDBClient repositoryDBClient = new RepositoryDBClient();
				repositoryDBClient.accessRepositoryDB(fileName);
				System.out.println("DBへの登録が完了しました");
			} else {
				throw new ArgumentInputException(outputControl);
			}

		}

	}
}
