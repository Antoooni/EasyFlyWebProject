package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.ChangeFlightDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.ChangeFlightService;

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
	public void changeFlightData(Flight flight) throws ServiceException {
		try {
			cancelFlight.changeFlightData(flight);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
