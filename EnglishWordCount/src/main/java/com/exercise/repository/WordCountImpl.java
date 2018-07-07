package com.exercise.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCountImpl implements WordCount {
	private static final String FILE_PATH = "src/main/resources/sample.txt"; //読み込みファイル名
	private static final String REGULAR_EXPRESSION = "^[a-z][a-zA-Z']+$"; //単語識別の正規表現

	@Override
	public Map<String, Integer> getEnglishWord() {

		Map<String, Integer> treeMap = new TreeMap<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
			String oneLine;
			while ((oneLine = bufferedReader.readLine()) != null) {
				String[] wordList = oneLine.split("\\s"); //単語に分割
				List<String> englishWords = Arrays.asList(wordList);

				englishWords.stream()
						.filter(v -> v.matches(REGULAR_EXPRESSION))//対象単語を抽出
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
		return treeMap;

	}
}
