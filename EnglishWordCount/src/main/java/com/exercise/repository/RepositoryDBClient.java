package com.exercise.repository;

import java.util.Map;

import com.exercise.resources.EnglishWord;

public class RepositoryDBClient {
	private EnglishWord englishWord;

	public RepositoryDBClient() {
		this.englishWord = englishWord;
	}

	public RepositoryDBClient(EnglishWord englishWord) {
		this.englishWord = englishWord;
	}

	public void accessRepositoryDB(String dbConnect) {

		WordCount wordCount = new WordCountImpl();
		RepositoryDB repositoryDB = new RepositoryDBImpl();

		int dbCount = 0;
		int updateCount = 0;
		int updateTotalCount = 0;
		int insertTotalCount = 0;


		for (Map.Entry<String, Integer> entry : wordCount.getEnglishWord().entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			EnglishWord englishWord = repositoryDB.getWcountDB(word, count, dbConnect);

			if (englishWord == null) {
				insertTotalCount++;
				repositoryDB.insertWcountDB(word, count, dbConnect);
			} else {
				updateTotalCount++;
				dbCount = englishWord.getCount();
				updateCount = count + dbCount;
				repositoryDB.updateWcountDB(word, updateCount, dbConnect);
			}
		}
		System.out.println("既存単語更新件数:" + updateTotalCount + "件");
		System.out.println("新規単語登録件数:" + insertTotalCount + "件");
	}

}
