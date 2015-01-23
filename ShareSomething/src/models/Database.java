package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			c = DriverManager.getConnection("jpa@localhost, user, password");
		} catch (Exception e) {
			System.err.println(e);
		}
		return c;
	}
}
