package com.exercise.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.exercise.util.Config;

public class WordCount {

	private static final String FOLDER_PATH = "src/main/resources/"; //フォルダ
	private static final String REGULAR_EXPRESSION = "^[a-z][a-zA-Z']+$"; //単語識別の正規表現

	public static WordCount getEnglishWord(Config config) {
		Map<String, Integer> treeMap = new TreeMap<>();
		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader(FOLDER_PATH + config.getInputConfig()))) {
			String oneLine;
			while ((oneLine = bufferedReader.readLine()) != null) {
				String[] wordList = oneLine.split("\\s");
				List<String> englishWords = Arrays.asList(wordList);

				englishWords.stream()
						.filter(v -> v.matches(REGULAR_EXPRESSION))
						.forEach(word -> {
							if (!treeMap.containsKey(word)) {
								treeMap.put(word, 1);
							} else {
								treeMap.put(word, treeMap.get(word).intValue() + 1);
							}
						});
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (WordCount) treeMap;
	}

}