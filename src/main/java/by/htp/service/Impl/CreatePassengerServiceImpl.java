package by.htp.service.Impl;

import by.htp.bin.Passenger;
import by.htp.dao.CreatePassengerDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;
import by.htp.service.CreatePassengerService;

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
