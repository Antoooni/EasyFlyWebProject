package by.htp.easyfly.dao;

import java.util.List;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.DAOException;

public interface FlightListDao {
	List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL) throws DAOException;

}
