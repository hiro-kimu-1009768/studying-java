package com.exercise.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.exercise.resources.EnglishWord;
import com.exercise.util.Input;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class RepositoryJson {

	public void getAllToJson(String folderPath, String fileName) {
		Path path = Paths.get(new Input().getFilePath(folderPath, fileName));
		File file = path.toFile();
		WordCount wordCount = new WordCountImpl();
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		ArrayNode jsonWordList = objectMapper.createArrayNode();
		for (Map.Entry<String, Integer> entory : wordCount.getEnglishWord().entrySet()) {
			EnglishWord englishWord = new EnglishWord(entory.getKey(), entory.getValue());
			jsonWordList.addPOJO(englishWord);
		}
		try {
			objectMapper.writeValue(file, jsonWordList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
