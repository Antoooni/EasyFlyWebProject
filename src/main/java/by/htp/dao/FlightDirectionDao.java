package by.htp.dao;

import java.util.List;

import by.htp.bin.FlightDirection;
import by.htp.exception.DAOException;

public interface FlightDirectionDao {
	List<FlightDirection> flightDirection() throws DAOException;
}
