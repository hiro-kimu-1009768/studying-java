package com.exercise.repository;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RepositoryJson {
	public String getAllToJson() {
		String json = null;
		try {
			WordCount wordCount = new WordCountImpl();
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(wordCount.getEnglishWord());
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
