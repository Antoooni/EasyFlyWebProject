package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Passenger;
import by.htp.easyfly.dao.CreatePassengerDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.CreatePassengerService;

public class CreatePassengerServiceImpl implements CreatePassengerService {
	private CreatePassengerDao buyTicketDao;
	// DaoFactory daoFactory = new DaoFactory();

	public CreatePassengerServiceImpl() {
		buyTicketDao = DaoFactory.getInstance().getCreatePassengerDao();
	}

	@Override
	public int passenger(Passenger passenger) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return buyTicketDao.passenger(passenger);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
