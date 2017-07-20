package by.htp.easyfly.service.Impl;

import java.util.List;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.dao.FlightDirectionDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionService;

public class DirectionServiceImpl implements DirectionService {
	private FlightDirectionDao daoDirection;
	// DaoFactory daoFactory = new DaoFactory() ;

	public DirectionServiceImpl() {
		daoDirection = DaoFactory.getInstance().getFlightDirectionDao();
	}

	@Override
	public List<FlightDirection> listDirections() throws ServiceException {
		try {
			return daoDirection.flightDirection();

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
