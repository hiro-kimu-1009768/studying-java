package com.exercise.repository;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RepositoryJson {
	public String getAllToJson() {
		String json = null;
		try {
			Map<String, Integer> treeMap = new WordCount().getEnglishWord();
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(treeMap);
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
