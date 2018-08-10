package com.exercise.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.exercise.entity.EnglishWord;
import com.exercise.util.Config;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class RepositoryJson extends WordCount {
	public static final String FOLDER_PATH = "src/main/resources/"; //フォルダ

	public void outputControl(Config config) {
		Path path = Paths.get(FOLDER_PATH + config.getOutputConfigDetail());
		File file = path.toFile();
		WordCount wordCount = new WordCount();
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		ArrayNode jsonWordList = objectMapper.createArrayNode();
		for (Map.Entry<String, Integer> entory : wordCount.getEnglishWord(config).entrySet()) {
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
