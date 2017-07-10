package by.htp.easyfly.service;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.TicketList;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;

public interface CreateTicketService {
	public int ticket(Ticket ticket) throws ServiceException;

	public int createTicketList(User user, int ticketId) throws ServiceException;

	public void updateUser(int userId, TicketList ticketList) throws ServiceException;

	public boolean ticketListExists(User user) throws ServiceException;

	public int searchTicketList(User user) throws ServiceException;

}
