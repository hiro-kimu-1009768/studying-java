package com.exercise.controller;

import com.exercise.repository.WordCount;
import com.exercise.util.ArgumentInputException;
import com.exercise.util.Config;

public interface IOController {

	static void outputControl(Config config, WordCount wordCount) throws ArgumentInputException {
		// TODO 自動生成されたメソッド・スタブ

	}

	//		if (config.getOutputConfigDetail() == null) {
	//			//コンソール出力処理
	//			IOController iOcontroller = new RepositoryConsole();
	//			iOcontroller.outputControl(config);
	//			RepositoryConsole repositoryConsole = new RepositoryConsole();
	//			repositoryConsole.outputControl(config);
	//		} else {
	//			String outputConfig = config.getOutputConfig().split("=")[0];
	//			if (outputConfig.equals("json")) {
	//				//jsonの出力処理
	//				System.out.println("JSONに出力します");
	//				RepositoryJson repositoryJson = new RepositoryJson();
	//				repositoryJson.outputControl(config);
	//				System.out.println("JSONへの出力が完了しました");
	//
	//			} else if (outputConfig.equals("H2")) {
	//				//DBの登録処理
	//				System.out.println("DBに登録します");
	//				RepositoryDBClient repositoryDBClient = new RepositoryDBClient();
	//				repositoryDBClient.outputControl(config);
	//				System.out.println("DBへの登録が完了しました");
	//			} else {
	//				throw new ArgumentInputException(config);
	//			}
	//
	//		}
	//
	//	}
}

