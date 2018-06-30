package com.exercise.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
	private static final String FILE_PATH = "src/main/resources/sample.txt"; //読み込みファイル名

	public static void main(String[] args) throws IOException {

		Map<String, Integer> treeMap = new TreeMap<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
			String oneLine;
			while ((oneLine = bufferedReader.readLine()) != null) {
				String[] wordsList = oneLine.split("\\s");
				for (String word : wordsList) {
					if (!treeMap.containsKey(word)) {
						treeMap.put(word, 1);
					} else {
						treeMap.put(word, treeMap.get(word).intValue() + 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<String> list = new ArrayList<>();
		int maxLengthOfSpelling = 0;
		for (String key : treeMap.keySet()) {
			list.add(key);

			if (maxLengthOfSpelling < key.length()) {
				maxLengthOfSpelling = key.length();
			}
		}

		Collections.sort(list, (o1, o2) -> {
			return -treeMap.get(o1) + treeMap.get(o2);
		});

		System.out.println("出現回数トップ10");
		String format = "%-" + maxLengthOfSpelling + "s: %3d";
		for (String word : list) {
			int count = treeMap.get(word);
			if (10 <= count) {
				System.out.printf(format, word, count);
				System.out.println();
			}

			//		for (String word : treeMap.keySet()) {
			//			System.out.println(word + " : " + treeMap.get(word));
		}
	}
}
