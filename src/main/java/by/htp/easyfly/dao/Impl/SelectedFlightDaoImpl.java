package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.easyfly.bin.Direction;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.Plane;
import by.htp.easyfly.dao.SelectedFlightDao;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class SelectedFlightDaoImpl implements SelectedFlightDao {
	
	

	@Override
	public Flight flight(int flightId) throws DAOException {
		Flight selectedFlight = null;
//		Connection connection = null;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()){
				
				PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT_SEARCH_SELECTED_FLIGHT);
				ps.setInt(1, flightId);
				ResultSet rs = ps.executeQuery(); // ��� ��� PreparedStatement
				
				Direction fromDirection = new Direction();
				Direction toDirection = new Direction();
				Plane plane = new Plane();
				
				if (rs.next()) {
					selectedFlight= new Flight();
					
					fromDirection.setDirectionCode(rs.getString(1));
					fromDirection.setDirectionName(rs.getString(2));
					selectedFlight.setFromDirection(fromDirection);
					
					selectedFlight.setDepartureDate(DateTimeTransform.convertDate(rs.getString(3)));
					selectedFlight.setDepartureTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(4)));
					
					toDirection.setDirectionCode(rs.getString(5));
					toDirection.setDirectionName(rs.getString(6));
					selectedFlight.setToDirection(toDirection);
					
					selectedFlight.setArrivalDate(DateTimeTransform.convertDate(rs.getString(7)));
					selectedFlight.setArrivalTime(DateTimeTransform.convertTimeHHMMSS(rs.getString(8)));
					
					selectedFlight.setFlightId( rs.getInt(9));
					
					plane.setPlaneName(rs.getString(10));
					selectedFlight.setPlane(plane);
					
					selectedFlight.setFlightCode(rs.getString(11));


				}
			} catch (SQLException e) {
			throw new DAOException("SQLException in method flight(): " + e);
		}
		return selectedFlight;
	}

}
