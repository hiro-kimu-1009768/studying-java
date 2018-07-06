package com.exercise.repository;

import java.util.Map;

import com.exercise.resources.EnglishWord;

public class RepositoryDBClient {
	private EnglishWord englishWord;

	protected RepositoryDBClient() {
		this.englishWord = englishWord;
	}

	protected RepositoryDBClient(EnglishWord englishWord) {
		this.englishWord = englishWord;
	}

	public void AccessRepositoryDB() {

		Map<String, Integer> treeMap = new WordCount().getEnglishWord();
		RepositoryDB repositoryDB = new RepositoryDBImpl();

		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			EnglishWord englishword = repositoryDB.getWcountDB(word, count);

			if (englishword == null) {
				repositoryDB.InsertWcountDB(word, count);
				System.out.println(englishWord);
			} else {
				int updateCount = count + englishWord.getCount();
				repositoryDB.UpdateWcountDB(word, updateCount);
				System.out.println(englishWord);
			}

		}
	}

}
