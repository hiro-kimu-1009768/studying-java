package com.exercise.entity;

import java.util.Map;

public class EnglishWord {

	private Map<String, Integer> englishWord;

	public Map<String, Integer> getEnglishWord() {
		return englishWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((englishWord == null) ? 0 : englishWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnglishWord other = (EnglishWord) obj;
		if (englishWord == null) {
			if (other.englishWord != null)
				return false;
		} else if (!englishWord.equals(other.englishWord))
			return false;
		return true;
	}



	public EnglishWord(Map<String, Integer> englishWord) {
		super();
		this.englishWord = englishWord;
	}



	@Override
	public String toString() {
		return "EnglishWord [englishWord=" + englishWord + "]";
	}
}