package by.htp.easyfly.service.Impl;

import java.util.List;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.FlightListDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.FlightListService;

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
