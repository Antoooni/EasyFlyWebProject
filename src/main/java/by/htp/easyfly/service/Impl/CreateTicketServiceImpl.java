package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.TicketList;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.CreateTicketDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.CreateTicketService;

public class CreateTicketServiceImpl implements CreateTicketService {
	private CreateTicketDao createTicketDao;
	// DaoFactory daoFactory = new DaoFactory();

	public CreateTicketServiceImpl() {
		createTicketDao = DaoFactory.getInstance().getCreateTicketDao();
	}

	@Override
	public int ticket(Ticket ticket) throws ServiceException {
		try {
			return createTicketDao.ticket(ticket);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int createTicketList(User user, int ticketId) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return createTicketDao.createTicketList(user, ticketId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateUser(int userId, TicketList ticketList) throws ServiceException {
		try {
			createTicketDao.updateUser(userId, ticketList);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean ticketListExists(User user) throws ServiceException {
		try {
			// TODO Auto-generated method stub
			return createTicketDao.ticketListExists(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int searchTicketList(User user) throws ServiceException {
		try {
			// TODO Auto-generated method stub
			return createTicketDao.searchTicketList(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
