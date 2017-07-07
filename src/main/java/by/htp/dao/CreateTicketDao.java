package by.htp.dao;

import by.htp.bin.Ticket;
import by.htp.bin.TicketList;
import by.htp.bin.User;
import by.htp.exception.DAOException;

public interface CreateTicketDao {
	public int ticket(Ticket ticket) throws DAOException;
	public int searchTicketList(User user) throws DAOException;
	public boolean ticketListExists(User user) throws DAOException;
	public int createTicketList(User user, int ticketId) throws DAOException;
	public void updateUser(int userId, TicketList ticketList) throws DAOException;

}
