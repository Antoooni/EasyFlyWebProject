package by.htp.service;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;
import by.htp.exception.ServiceException;

public interface CreateTicketService {
	public int ticket(Ticket ticket) throws ServiceException;

	public int createTicketList(User user, int ticketId) throws ServiceException;

	public void updateUser(int userId, TicketList ticketList) throws ServiceException;

	public boolean ticketListExists(User user) throws ServiceException;

	public int searchTicketList(User user) throws ServiceException;

}
