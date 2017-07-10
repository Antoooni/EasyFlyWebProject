package by.htp.easyfly.dao;

import java.util.List;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.exception.DAOException;

public interface FlightDirectionDao {
	List<FlightDirection> flightDirection() throws DAOException;
}
