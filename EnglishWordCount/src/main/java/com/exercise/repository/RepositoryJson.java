package com.exercise.repository;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.exercise.resources.EnglishWord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class RepositoryJson {
	private static final String OUTFILE_PATH = "src/main/resources/output.json"; //書き込みファイル名

	public String getAllToJson() {
		String json = null;
		try {
			File file = new File(OUTFILE_PATH);
			WordCount wordCount = new WordCountImpl();
			wordCount.getEnglishWord();
			ObjectMapper objectMapper = new ObjectMapper()
					.enable(SerializationFeature.INDENT_OUTPUT);
			ArrayNode rootNode = objectMapper.createArrayNode();
			for (Map.Entry<String, Integer> entory : wordCount.getEnglishWord().entrySet()) {
				EnglishWord englishWord = new EnglishWord(entory.getKey(), entory.getValue());
				rootNode.addPOJO(englishWord);
				json = objectMapper.writeValueAsString(englishWord);
				objectMapper.writeValue(file, rootNode);
				System.out.println(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
