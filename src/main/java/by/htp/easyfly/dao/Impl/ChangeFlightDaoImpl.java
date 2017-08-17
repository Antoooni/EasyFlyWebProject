package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.*;

import by.htp.easyfly.dao.ChangeFlightDao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.*;
import by.htp.easyfly.util.SQLConnectionPool;

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
                    Date d1= new java.sql.Date(flight.getDepartureDate().getTime());
                    String departure=d1.toString();
                    ps.setString(1,departure);
					ps.setString(2, String.valueOf(flight.getDepartureTime()));
                    Date d2=new java.sql.Date(flight.getArrivalDate().getTime());
                    String arrival=d2.toString();
                    ps.setString(3, arrival);
					ps.setString(4, String.valueOf(flight.getArrivalTime()));
					ps.setInt(5, flight.getFlightId());
					ps.executeUpdate();
				}

			}   catch (SQLException e) {
			throw new DAOException("SQLException in method changeFlightData(): " + e);
		}

	}

}
