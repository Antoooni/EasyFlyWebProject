package by.htp.easyfly.dao;

import java.util.Date;
import java.util.List;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.DAOException;

public interface FlightListDao {
	List<Flight> flightList(String fromSQL, String toSQL, Date departureDateSQL, Date arrivalDateSQL) throws DAOException;

}
