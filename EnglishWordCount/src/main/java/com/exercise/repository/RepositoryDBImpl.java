package com.exercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercise.resources.EnglishWord;
import com.exercise.util.Connections;
import com.exercise.util.Input;

public class RepositoryDBImpl implements RepositoryDB {
	private static final String WORD_SELECT_SQL = "SELECT word, count FROM wcount WHERE word = ?";
	private static final String WORD_UPDATE_SQL = "UPDATE wcount SET count = ? WHERE word = ?";
	private static final String WORD_INSERT_SQL = "INSERT INTO WCOUNT (word, count) VALUES (?,?)";

	@Override
	public EnglishWord getWcountDB(String word, int count, String dbConnect) {
		try (Connection connection = Connections.getConnection(new Input().getDBConnectName(dbConnect));
				PreparedStatement statement = connection.prepareStatement(WORD_SELECT_SQL)) {
			statement.setString(1, word);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int db_count = resultSet.getInt("count");
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
	public void updateWcountDB(String word, int count, String dbConnect) {
		try (Connection connection = Connections.getConnection(new Input().getDBConnectName(dbConnect));
				PreparedStatement statement = connection.prepareStatement(WORD_UPDATE_SQL)) {
			statement.setString(2, word);
			statement.setInt(1, count);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertWcountDB(String word, int count, String dbConnect) {
		try (Connection connection = Connections.getConnection(new Input().getDBConnectName(dbConnect));
				PreparedStatement statement = connection.prepareStatement(WORD_INSERT_SQL)) {
			statement.setString(1, word);
			statement.setInt(2, count);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
