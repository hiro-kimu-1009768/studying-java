package com.exercise.repository;

import com.exercise.resources.EnglishWord;

public interface RepositoryDB {

	EnglishWord getWcountDB(String word, int count, String dbConnect);

	void updateWcountDB(String word, int count, String dbConnect);

	void insertWcountDB(String word, int count, String dbConnect);

}
