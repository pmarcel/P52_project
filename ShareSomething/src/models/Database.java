package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public Object querry() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/artbase";
			String user = "user";
			String password = "1234";
			
			c = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		
		return c;
	}
}
