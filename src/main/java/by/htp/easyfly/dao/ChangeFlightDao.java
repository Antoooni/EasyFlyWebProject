package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.DAOException;

public interface ChangeFlightDao {
	//public Flight changeFlightDepartureDate() ;
	public void cancelFlight(Flight flight) throws DAOException;
	public void changeFlightData(Flight flight) throws DAOException;
}
