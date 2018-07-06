package com.exercise.repository;

import java.util.Map;

import com.exercise.resources.EnglishWord;

public class RepositoryDBClient {
	private EnglishWord englishWord;

	public RepositoryDBClient() {
		this.englishWord = englishWord;
	}

	protected RepositoryDBClient(EnglishWord englishWord) {
		this.englishWord = englishWord;
	}

	public void AccessRepositoryDB() {

		Map<String, Integer> treeMap = new WordCount().getEnglishWord();
		RepositoryDB repositoryDB = new RepositoryDBImpl();

		int dbCount = 0;
		int updateCount = 0;
		int updateTotalCount = 0;
		int insertTotalCount = 0;

		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			EnglishWord englishWord = repositoryDB.getWcountDB(word, count);

			if (englishWord == null) {
				insertTotalCount++;
				repositoryDB.InsertWcountDB(word, count);
			} else {
				updateTotalCount++;
				dbCount = englishWord.getCount();
				updateCount = count + dbCount;
				repositoryDB.UpdateWcountDB(word, updateCount);
			}
		}
		System.out.println("update_count" + updateTotalCount);
		System.out.println("insert_count" + insertTotalCount);
	}

}
