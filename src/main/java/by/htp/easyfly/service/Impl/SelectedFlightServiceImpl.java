package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.SelectedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SelectedFlightService;
/**
 * @author Anton Mazets
 * Class is implementation of interface that is a service for selection flight info
 * @see by.htp.easyfly.service.SelectedFlightService
 * @since 1.0
 */
public class SelectedFlightServiceImpl implements SelectedFlightService {
	private final SelectedFlightDao selectedFlightDao;

	public SelectedFlightServiceImpl(SelectedFlightDao selectedFlightDao) {
        this.selectedFlightDao=selectedFlightDao;
	}

	@Override
	public Flight flight(int flightId) throws ServiceException {
		try {
            return selectedFlightDao.flight(flightId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
