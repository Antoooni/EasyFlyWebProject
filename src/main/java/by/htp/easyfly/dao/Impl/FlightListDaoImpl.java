package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.easyfly.bin.Direction;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.FlightListDao;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class FlightListDaoImpl implements FlightListDao {
	Connection connection;

	@Override
	public List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL)
			throws DAOException {
		// ResourceBundle bundle = ResourceBundle.getBundle("config");
		// String dbUrl=bundle.getString("db.url");
		// String dbUser =bundle.getString("db.login");
		// String dbPass=bundle.getString("db.pass");
		// System.out.println(dbUrl+" "+" "+dbUser+" "+ dbPass);
		// String dbName =bundle.getString("db.driver.name");

		List<Flight> flightList = new ArrayList<Flight>();
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			if (!connection.isClosed()) {
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_FLIGHT);

				ps.setString(1, fromSQL);
				ps.setString(2, toSQL);
				ps.setString(3, departureDateSQL);
				ps.setString(4, arrivalDateSQL);
				ResultSet rs = ps.executeQuery();
				Direction fromDirection = new Direction();
				Direction fromDirectionCode = new Direction();
				Direction toDirection = new Direction();
				while (rs.next()) { // ���� ��� ���� ������� �� ��

					// String fromDirectionString = rs.getString(1);
					// Direction d = new Direction();
					// d.setDirectionCode(fromDirectionString);
					fromDirection.setDirectionCode(rs.getString(1));
					fromDirection.setCity(rs.getString(2));

					String departureDate = rs.getString(3);
					String departureTime = rs.getString(4);

					toDirection.setDirectionCode(rs.getString(5));
					toDirection.setCity(rs.getString(6));

					String arrivalDate = rs.getString(7);
					String arrivalTime = rs.getString(8);
					int flightId = rs.getInt(9);
					String flightCode = rs.getString(10);
					flightList.add(new Flight(fromDirectionCode, fromDirection, departureDate, departureTime,
							toDirection, arrivalDate, arrivalTime, flightId, flightCode));
				}
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method flightList(): " + e);
		}
		return flightList;
	}

}
