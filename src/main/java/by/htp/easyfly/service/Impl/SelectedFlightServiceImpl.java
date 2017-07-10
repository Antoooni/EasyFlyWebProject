package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.SelectedFlightDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SelectedFlightService;

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
