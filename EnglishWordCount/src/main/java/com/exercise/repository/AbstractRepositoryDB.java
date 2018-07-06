package com.exercise.repository;

import java.util.Map;

import com.exercise.resources.EnglishWord;

public class AbstractRepositoryDB implements RepositoryDB {
	private EnglishWord englishWord;

	protected AbstractRepositoryDB() {
		this.englishWord = englishWord;
	}

	protected AbstractRepositoryDB(EnglishWord englishWord) {
		this.englishWord = englishWord;
	}

	public void RepositoryDBxx() {

		Map<String, Integer> treeMap = new WordCount().getEnglishWord();
		RepositoryDB repositoryDB = new RepositoryDBImpl();

		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			EnglishWord englishword = repositoryDB.getWcountDB(word, count);
			if (englishWord == null) {
				InsertWcountDB(word, count);
			} else {
				UpdateWcountDB(word, count);
			}

		}
	}

	@Override
	public EnglishWord getWcountDB(String word, int count) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void UpdateWcountDB(String word, int count) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void InsertWcountDB(String word, int count) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
