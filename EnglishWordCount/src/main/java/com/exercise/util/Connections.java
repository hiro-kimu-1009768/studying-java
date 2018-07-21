package com.exercise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static Connection getConnection(String dbConnectName) throws SQLException {
		String[] dbConnect = dbConnectName.split(",");
		String serverName = dbConnect[0];
		String userName = dbConnect[1];
		String password = dbConnect[2];

		return DriverManager.getConnection(serverName,userName,password);
	}
}
