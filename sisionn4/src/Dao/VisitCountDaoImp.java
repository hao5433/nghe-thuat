package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitCountDaoImp extends ConnectionDao implements VisitCountDao {

	@Override
	public int getNumberOfVisits() {
		Connection connection = super.getConnetion();
		String sql = "SELECT count FROM click_counter WHERE id = 1;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return resultSet.getInt("count");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return 0;
	}

	@Override
	public void incrementNumberOfVisits() {
		Connection connection = super.getConnetion();
		String sql = "UPDATE click_counter SET count = ? WHERE id = 1;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, getNumberOfVisits() + 1);
			preparedStatement.executeUpdate();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
