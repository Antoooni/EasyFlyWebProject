package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.easyfly.dao.DirectionCodeDao;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

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
				ps.setString(1, direction); // ��� ��� PreparedStatement
				ResultSet rs = ps.executeQuery(); // ��� ��� PreparedStatement
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
