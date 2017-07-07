package by.htp.dao;

import static by.htp.util.ConstantValue.*;
import static by.htp.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import by.htp.bin.User;
import by.htp.dao.UserAuthorizationDao;
import by.htp.util.SQLConnectionPool;
import by.htp.exception.*;

public class UserAuthorizationDaoImpl implements UserAuthorizationDao {

	@Override
	public User getUserData(String login, String password) throws DAOException {
		User user = new User();
//		Connection connection = null;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_USER_NAME);
			ps.setString(1, login); // код для PreparedStatement
			ps.setString(2, password); // код для PreparedStatement
			ResultSet rs = ps.executeQuery(); // код для PreparedStatement
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
