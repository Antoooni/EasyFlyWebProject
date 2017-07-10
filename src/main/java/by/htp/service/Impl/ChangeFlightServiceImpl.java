package by.htp.service.Impl;

import by.htp.bin.Flight;
import by.htp.dao.ChangeFlightDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;
import by.htp.service.ChangeFlightService;

public class ChangeFlightServiceImpl implements ChangeFlightService {
	private ChangeFlightDao cancelFlight;

	public ChangeFlightServiceImpl() {
		cancelFlight = DaoFactory.getInstance().getChangeFlightDao();
	}

	@Override
	public void cancelFlight(Flight flight) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			cancelFlight.cancelFlight(flight);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void chancheFlightData(Flight flight) throws ServiceException {
		try {
			cancelFlight.changeFlightData(flight);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
