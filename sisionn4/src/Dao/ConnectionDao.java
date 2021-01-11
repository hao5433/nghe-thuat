package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	public Connection getConnetion() {
		final String url = "jdbc:mysql://localhost:3306/nhanvien";
		final String user = "root";
		final String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ConnectionDao connectionDao = new ConnectionDao();
		Connection connection = connectionDao.getConnetion();
		if (connection != null) {
			System.out.println("thanh cong ");
		} else
			System.out.println("that bai ");

	}

}
