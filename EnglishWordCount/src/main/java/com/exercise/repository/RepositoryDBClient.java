package com.exercise.repository;

import java.util.Map;

import com.exercise.entity.EnglishWord;
import com.exercise.util.Config;

public class RepositoryDBClient extends WordCount {

	public void outputControl(Config config) {

		WordCount wordCount = new WordCount();
		RepositoryDB repositoryDB = new RepositoryDB();

		int dbCount = 0;
		int updateCount = 0;
		int updateTotalCount = 0;
		int insertTotalCount = 0;

		for (Map.Entry<String, Integer> entry : wordCount.getEnglishWord(config).entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			EnglishWord englishWord = repositoryDB.getWcountDB(new EnglishWord(word, count), config);

			if (englishWord == null) {
				insertTotalCount++;
				repositoryDB.insertWcountDB(new EnglishWord(word, count), config);
			} else {
				updateTotalCount++;
				dbCount = englishWord.getCount();
				updateCount = count + dbCount;
				repositoryDB.updateWcountDB(englishWord, config);
			}
		}
		System.out.println("既存単語更新件数:" + updateTotalCount + "件");
		System.out.println("新規単語登録件数:" + insertTotalCount + "件");
	}

}

