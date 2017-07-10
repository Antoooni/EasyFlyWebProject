package by.htp.service.Impl;

import java.util.List;

import by.htp.bin.FlightDirection;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;
import by.htp.service.DirectionService;

public class DirectionServiceImpl implements DirectionService {
	private FlightDirectionDao daoDirection;
	// DaoFactory daoFactory = new DaoFactory() ;

	public DirectionServiceImpl() {
		daoDirection = DaoFactory.getInstance().getFlightDirectionDao();
	}

	@Override
	public List<FlightDirection> listDirections() throws ServiceException {
		/* List<FlightDirection> directions = */
		try {
			return daoDirection.flightDirection();

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
