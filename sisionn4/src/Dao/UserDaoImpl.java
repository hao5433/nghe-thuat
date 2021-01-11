package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import model.User;

public class UserDaoImpl extends ConnectionDao implements UserDao {

	@Override
	public void create(User user) throws Exception {
		Connection connection = super.getConnetion();
		String sql = "INSERT INTO taikhoan(ten,matkhau,gioitinh) value (?, ?, ?);";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, "user");
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new Exception("Username already in database!");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	@Override
	public User find(String username) {
		Connection connection = super.getConnetion();
        String sql = "SELECT * FROM taikhoan WHERE ten = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("ten"),
                        resultSet.getString("matkhau"),
                        resultSet.getString("gioitinh")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    

	}

}
