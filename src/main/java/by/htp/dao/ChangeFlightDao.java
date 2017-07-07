package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.exception.DAOException;

public interface ChangeFlightDao {
	//public Flight changeFlightDepartureDate() ;
	public void cancelFlight(Flight flight) throws DAOException;
	public void changeFlightData(Flight flight) throws DAOException;
}
