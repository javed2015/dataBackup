package com.votsh.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	static Connection con;

	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba",
					"admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
