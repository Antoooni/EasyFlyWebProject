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

import by.htp.bin.Direction;
import by.htp.dao.DirectionCodeDao;
import by.htp.util.SQLConnectionPool;
import by.htp.exception.*;

public class DirectionCodeDaoImpl implements DirectionCodeDao {

	@Override
	public String directionCode(String direction) throws DAOException {
//		Connection connection = null;
		String directionCode=null;

//		 ResourceBundle bundle = ResourceBundle.getBundle("config");
//		 String dbUrl = bundle.getString("db.url");
//		 String dbUser = bundle.getString("db.login");
//		 String dbPass = bundle.getString("db.pass");
//		 System.out.println(dbUrl + " " + " " + dbUser + " " + dbPass);
//		 String dbName = bundle.getString("db.driver.name");

		try (Connection connection = SQLConnectionPool.getDs().getConnection()){
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_DIRECTION_CODE);
				ps.setString(1, direction); // код для PreparedStatement
				ResultSet rs = ps.executeQuery(); // код для PreparedStatement
				if (rs.next()) {
					directionCode = rs.getString(1);
					System.out.println("Converted code: " + directionCode);

				}
			} catch (SQLException e) {
			
				throw new DAOException("SQLException in method directionCode(): " + e);
		}
		return directionCode;
	}


}
