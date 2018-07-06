package com.exercise.resources;

public class EnglishWord {
	private String word;
	private int count;

	public String getWord() {
		return word;

	}

	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		if (count != other.count)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnglishWord [word=" + word + ", count=" + count + "]";
	}

	public EnglishWord(String word, int count) {
		this.word = word;
		this.count = count;
//		Map<String, Integer> englishWord = (Map<String, Integer>) new EnglishWord(word, count);
	}

	public EnglishWord() {
		this(null,0);

//		Map<String, Integer> englishWord = (Map<String, Integer>) new EnglishWord(word, count);

	}
}
