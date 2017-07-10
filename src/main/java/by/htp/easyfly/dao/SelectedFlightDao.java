package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.DAOException;

public interface SelectedFlightDao {
	Flight flight(int flightId) throws DAOException;
}
