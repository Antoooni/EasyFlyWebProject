package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.SearchChangedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SearchChangedFlightService;

/**
 * @author Anton Mazets
 * Class is implementation of interface that is a service for searching changed or cancelled flight
 * @see by.htp.easyfly.service.SearchChangedFlightService
 * @since 1.0
 */
public class SearchChangedFlightServiceImpl implements SearchChangedFlightService {
    private final SearchChangedFlightDao searchChangedFlightDao;

    public SearchChangedFlightServiceImpl(SearchChangedFlightDao searchChangedFlightDao){
        this.searchChangedFlightDao=searchChangedFlightDao;
    }

    /**
     *
     * @param user for which being searched for changed flight
     * @return changed flight info for current user
     * @throws ServiceException
     */
    @Override
    public Flight searchChangedFlight(User user) throws ServiceException {

    try {
        return searchChangedFlightDao.searchChangedFlight(user);

    } catch (DAOException e) {
        throw new ServiceException(e);
    }
}
    /**
     *
     * @param user for which being searched for cancelled flight
     * @return cancelled flight info for current user
     * @throws ServiceException
     */
    @Override
    public Flight searchCancelledFlight(User user) throws ServiceException {
        try {
            return searchChangedFlightDao.searchCancelledFlight(user);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
