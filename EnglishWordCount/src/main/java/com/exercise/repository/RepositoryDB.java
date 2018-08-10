package com.exercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercise.entity.EnglishWord;
import com.exercise.util.Config;
import com.exercise.util.Connections;

public class RepositoryDB {
	private static final String WORD_SELECT_SQL = "SELECT word, count FROM wcount WHERE word = ?";
	private static final String WORD_UPDATE_SQL = "UPDATE wcount SET count = ? WHERE word = ?";
	private static final String WORD_INSERT_SQL = "INSERT INTO WCOUNT (word, count) VALUES (?,?)";

	public EnglishWord getWcountDB(EnglishWord englishWord, Config config) {
		try (Connection connection = Connections.getConnection(config.getOutputConfigDetail());
				PreparedStatement statement = connection.prepareStatement(WORD_SELECT_SQL)) {
			statement.setString(1, englishWord.getWord());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int db_count = resultSet.getInt("count");
					return new EnglishWord(englishWord.getWord(), db_count);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateWcountDB(EnglishWord englishWord, Config config) {
		try (Connection connection = Connections.getConnection(config.getOutputConfigDetail());
				PreparedStatement statement = connection.prepareStatement(WORD_UPDATE_SQL)) {
			statement.setString(2, englishWord.getWord());
			statement.setInt(1, englishWord.getCount());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertWcountDB(EnglishWord englishWord, Config config) {
		try (Connection connection = Connections.getConnection(config.getOutputConfigDetail());
				PreparedStatement statement = connection.prepareStatement(WORD_INSERT_SQL)) {
			statement.setString(1, englishWord.getWord());
			statement.setInt(2, englishWord.getCount());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
