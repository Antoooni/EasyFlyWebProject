package by.htp.service;

import java.util.List;

import by.htp.bin.Flight;
import by.htp.dao.FlightListDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;

public class FlightListServiceImpl implements FlightListService {
	private FlightListDao daoFlightList;
//	DaoFactory daoFactory = new DaoFactory();
	
	public FlightListServiceImpl(){
		daoFlightList= DaoFactory.getInstance().getFlightListDao();
	}

	@Override
	public List<Flight> flightList(String fromSQL, String toSQL, String departureDateSQL, String arrivalDateSQL)
			throws ServiceException {
		try{
		List<Flight>flightList=daoFlightList.flightList( fromSQL,  toSQL,  departureDateSQL,  arrivalDateSQL);
		return flightList;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
