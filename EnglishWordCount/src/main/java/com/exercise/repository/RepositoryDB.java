package com.exercise.repository;

import com.exercise.resources.EnglishWord;

public interface RepositoryDB {

	EnglishWord getWcountDB(String word, int count);

	void UpdateWcountDB(String word, int count);

	void InsertWcountDB(String word, int count);

}
