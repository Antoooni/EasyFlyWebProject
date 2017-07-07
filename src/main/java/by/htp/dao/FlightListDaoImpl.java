package by.htp.dao;

import static by.htp.util.ConstantValue.*;
import static by.htp.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import by.htp.bin.Direction;
import by.htp.bin.Flight;
import by.htp.dao.FlightListDao;
import by.htp.util.SQLConnectionPool;
import by.htp.exception.*;

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
				while (rs.next()) { // цикл для всех записей из БД

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
