package by.htp.dao;

import static by.htp.util.ConstantValue.*;
import static by.htp.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mysql.jdbc.Statement;

import by.htp.bin.Flight;
//import by.htp.util.SQLConnectionPool;
import by.htp.exception.*;
import by.htp.util.SQLConnectionPool;

public class ChangeFlightDaoImpl implements ChangeFlightDao {
	Connection connection;
	PreparedStatement ps;

	@Override
	public void cancelFlight(Flight flight) throws DAOException  {
		try (Connection connection = SQLConnectionPool.getDs().getConnection()){
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CANCEL_FLIGHT);
					ps.setInt(1, flight.getFlightId());
					ps.executeUpdate();
				}

			}  catch (SQLException e) {
			throw new DAOException("SQLException in method cancelFlight(): " + e);
		}
	}

	@Override
	public void changeFlightData(Flight flight) throws DAOException {
		try (Connection connection = SQLConnectionPool.getDs().getConnection()){
				if (!connection.isClosed()) {
					ps = connection.prepareStatement(SQL_STATEMENT_CHANGE_FLIGHT_DATA);
					ps.setString(1, flight.getDepartureDate());
					ps.setString(2, flight.getDepartureTime());
					ps.setString(3, flight.getArrivalDate());
					ps.setString(4, flight.getArrivalTime());
					ps.setInt(5, flight.getFlightId());
					ps.executeUpdate();
				}

			}   catch (SQLException e) {
			throw new DAOException("SQLException in method changeFlightData(): " + e);
		}

	}

}
