package by.htp.dao;

import static by.htp.util.ConstantValue.*;
import static by.htp.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import by.htp.bin.User;
import by.htp.dao.UserCreateDao;
import by.htp.util.SQLConnectionPool;
import by.htp.exception.*;

public class UserCreateDaoImpl implements UserCreateDao {
	// Connection connection;
	User user;
	//
	// ResourceBundle bundle = ResourceBundle.getBundle("config");
	// String dbUrl = bundle.getString("db.url");
	// String dbUser = bundle.getString("db.login");
	// String dbPass = bundle.getString("db.pass");
	// // System.out.println(dbUrl+" "+" "+dbUser+" "+ dbPass);
	// String dbName = bundle.getString("db.driver.name");

	@Override
	public User createUser(User user) throws DAOException {
		// Connection connection;
		// SQLConnectionPool sqlConnection = new SQLConnectionPool();
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			// Class.forName(dbName);
			// connection = DriverManager.getConnection(dbUrl, dbUser,
			// dbPass);

			PreparedStatement updateLogonData = null;
			PreparedStatement updateUserData = null;
			if (!connection.isClosed()) {
				// connection.setAutoCommit(false);
				String test_email = user.getUserEmail();
				System.out.println(test_email);
				updateLogonData = connection.prepareStatement(SQL_STATEMENT_CREATE_USER_LOGON_DATA);
				updateLogonData.setString(1, user.getLogonData().getLogin());
				updateLogonData.setString(2, user.getLogonData().getPassword());
				updateLogonData.executeUpdate();
				updateUserData = connection.prepareStatement(SQL_STATEMENT_CREATE_USER_DATA);
				updateUserData.setString(1, user.getUserName());
				updateUserData.setString(2, user.getUserSurname());
				updateUserData.setString(3, user.getUserEmail());
				updateUserData.setString(4, user.getLogonData().getLogin());
				updateUserData.executeUpdate();
				// connection.commit();
			}
		} catch (SQLException e) {
			throw new DAOException("Exception in method createUser(): " + e);
		}
		// finally {
		// connection.close();
		// }

		return user;
	}

	@Override
	public boolean checkExistUser(String login) throws DAOException {
		int numberOfUserExist = 0;
		PreparedStatement ps;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_IF_USER_LOGIN_EXIST);
				ps.setString(1, login);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					numberOfUserExist = rs.getInt(1);
				}
				// ps.executeUpdate();
			}

		}

		catch (SQLException e) {
			throw new DAOException("SQLException in method checkExistUser(): " + e);
		}
		if (numberOfUserExist == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean checkExistUserEmail(String email) throws DAOException {
		int numberOfUserExist = 0;
		PreparedStatement ps;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_IF_USER_EMAIL_EXIST);
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					numberOfUserExist = rs.getInt(1);
				}
				// ps.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method checkExistUserEmail(): " + e);
		}
		if (numberOfUserExist == 0)
			return false;
		else
			return true;
	}
}
