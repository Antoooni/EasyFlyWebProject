package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.SearchChangedFlightDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SearchChangedFlightService;

/**
 * Created by Ayumazec on 20.07.2017.
 */
public class SearchChangedFlightServiceImpl implements SearchChangedFlightService {
    private SearchChangedFlightDao searchChangedFlightDao;

    public SearchChangedFlightServiceImpl(){
        searchChangedFlightDao=DaoFactory.getInstance().getSearchChangedFlightDao();
    }
    @Override
    public Flight searchChangedFlight(User user) throws ServiceException {

    try {
        return searchChangedFlightDao.searchChangedFlight(user);

    } catch (DAOException e) {
        throw new ServiceException(e);
    }
}

    @Override
    public Flight searchCancelledFlight(User user) throws ServiceException {
        try {
            return searchChangedFlightDao.searchCancelledFlight(user);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
