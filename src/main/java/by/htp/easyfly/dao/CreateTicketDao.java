package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.TicketList;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;

public interface CreateTicketDao {
	public int createTicket(Ticket ticket) throws DAOException;
	public int searchTicketList(User user) throws DAOException;
	public boolean ticketListExists(User user) throws DAOException;
	public int createTicketList(User user, int ticketId) throws DAOException;
	public void updateUser(int userId, TicketList ticketList) throws DAOException;

}
