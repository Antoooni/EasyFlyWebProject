package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.dao.FlightDirectionDao;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class FlightDirectionDaoImpl implements FlightDirectionDao {

	@Override
	public List<FlightDirection> flightDirection() throws DAOException {
		// ResourceBundle bundle = ResourceBundle.getBundle("config");
		// String dbUrl=bundle.getString("db.url");
		// String dbUser =bundle.getString("db.login");
		// String dbPass=bundle.getString("db.pass");
		// System.out.println(dbUrl+" "+" "+dbUser+" "+ dbPass);
		// String dbName =bundle.getString("db.driver.name");
		//
		List<FlightDirection> flightDirection = new ArrayList<FlightDirection>();
//		Connection connection = null;
		String cityDirection = null;

		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			if (!connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_ALL_DIRECTIONS);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					cityDirection = rs.getString(1);
					flightDirection.add(new FlightDirection(cityDirection) {
						private static final long serialVersionUID = -1930855792331760955L;
					});
					System.out.println("City: " + cityDirection);

				}
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method flightDirection(): " + e);
		}

		return flightDirection;
	}

}
