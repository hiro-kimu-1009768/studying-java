package com.exercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercise.resources.EnglishWord;
import com.exercise.util.Connections;

public class RepositoryDBImpl extends AbstractRepositoryDB implements RepositoryDB {
	private final String WORD_SELECT_SQL = "SELECT word, count FROM wcount WHERE word = ?";
	private final String WORD_UPDATE_SQL = "UPDATE wcount SET count WHERE word = ?";
	private final String WORD_INSERT_SQL = "INSERT INTO wcount (word, count) VALUES ('?', ?)";

	@Override
	public EnglishWord getWcountDB(String word, int count) {
		try (Connection connection = Connections.getConnection();
				PreparedStatement statement = connection.prepareStatement(WORD_SELECT_SQL)) {
			statement.setString(1, word);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int db_count = resultSet.getInt("count") + count;
					return new EnglishWord(word, db_count);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateWcountDB(String word, int count) {
		try (Connection connection = Connections.getConnection();
				PreparedStatement statement = connection.prepareStatement(WORD_UPDATE_SQL)) {
			statement.setString(1, word);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int db_count = resultSet.getInt("count") + count;
				} else {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void InsertWcountDB(String word, int count) {
		try (Connection connection = Connections.getConnection();
				PreparedStatement statement = connection.prepareStatement(WORD_INSERT_SQL)) {
			statement.setString(1, word);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int db_count = resultSet.getInt("count") + count;
				} else {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
