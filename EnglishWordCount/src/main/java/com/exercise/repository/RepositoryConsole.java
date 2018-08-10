package com.exercise.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.exercise.controller.IOController;
import com.exercise.util.Config;

public class RepositoryConsole implements IOController {

	public void outputControl(Config config, WordCount wordCount) {

		WordCount wordCount = new WordCount();
		Map<String, Integer> wordMap = (Map<String, Integer>) wordCount.getEnglishWord(config);
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
