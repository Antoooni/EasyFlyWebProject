package by.htp.easyfly.service;

import java.util.List;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.exception.ServiceNoSuchFlightsException;

public interface FlightListService   {
	List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL)
			throws ServiceNoSuchFlightsException, ServiceException;

}
