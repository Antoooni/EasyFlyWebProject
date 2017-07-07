package by.htp.service;

import java.util.List;

import by.htp.bin.Flight;
import by.htp.exception.ServiceException;
import by.htp.exception.ServiceNoSuchFlightsException;

public interface FlightListService   {
	List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL)
			throws ServiceNoSuchFlightsException, ServiceException;

}
