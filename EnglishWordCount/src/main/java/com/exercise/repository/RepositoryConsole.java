package com.exercise.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RepositoryConsole {

	public void getEnglishWordConsole() {

		WordCount wordCount = new WordCountImpl();
		Map<String, Integer> wordMap = wordCount.getEnglishWord();
		List<String> list = new ArrayList<>();

		for (String key : wordMap.keySet()) {
			list.add(key);
		}
		Collections.sort(list, (o1, o2) -> {
			return -wordMap.get(o1) + wordMap.get(o2);
		});

		for (String word : list) {
			int count = wordMap.get(word);
			System.out.println(count + ":" + word);
		}
	}
}
