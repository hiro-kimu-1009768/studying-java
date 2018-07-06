package com.exercise.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RepositoryConsole {

	public void getEnglishWordCosole() {

		Map<String, Integer> treeMap = new WordCount().getEnglishWord();
		List<String> list = new ArrayList<>();

		for (String key : treeMap.keySet()) {
			list.add(key);
		}
		Collections.sort(list, (o1, o2) -> {
			return -treeMap.get(o1) + treeMap.get(o2);
		});

		for (String word : list) {
			int count = treeMap.get(word);
			System.out.println(count + ":" + word);
		}
	}
}
