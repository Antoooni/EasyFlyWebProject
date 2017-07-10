package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.UserAuthorizationDao;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class UserAuthorizationDaoImpl implements UserAuthorizationDao {

	@Override
	public User getUserData(String login, String password) throws DAOException {
		User user = new User();
//		Connection connection = null;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_USER_NAME);
			ps.setString(1, login); // ��� ��� PreparedStatement
			ps.setString(2, password); // ��� ��� PreparedStatement
			ResultSet rs = ps.executeQuery(); // ��� ��� PreparedStatement
			if (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setUserSurname(rs.getString(2));
				user.setRole(rs.getString(3));
				user.setUserId(rs.getInt(4));
				System.out.println("User name from database: " + user.getUserId() + " " + user.getUserName() + " "
						+ user.getUserSurname() + " " + user.getRole());

			}
		} catch (SQLException e) {
			throw new DAOException("SQLException in method getUserData(): " + e);
		}

		return user;
	}

}
