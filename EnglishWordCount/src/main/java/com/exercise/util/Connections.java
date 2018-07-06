package com.exercise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

}
