package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.exception.DAOException;

public interface SelectedFlightDao {
	Flight flight(int flightId) throws DAOException;
}
