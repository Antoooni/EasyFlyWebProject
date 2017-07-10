package by.htp.service.Impl;

import by.htp.bin.Flight;
import by.htp.dao.SelectedFlightDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;
import by.htp.service.SelectedFlightService;

public class SelectedFlightServiceImpl implements SelectedFlightService {
	private SelectedFlightDao selectedFlightDao;
	// DaoFactory daoFactory = new DaoFactory();

	public SelectedFlightServiceImpl() {
		selectedFlightDao = DaoFactory.getInstance().getSelectedFlightDao();
	}

	@Override
	public Flight flight(int flightId) throws ServiceException {
		try {
			Flight selectedFlight = selectedFlightDao.flight(flightId);
			return selectedFlight;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
