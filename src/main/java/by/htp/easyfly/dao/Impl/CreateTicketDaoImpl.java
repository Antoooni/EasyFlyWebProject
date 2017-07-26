package by.htp.easyfly.dao.Impl;

import static by.htp.easyfly.util.SQLConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.easyfly.dao.CreateTicketDao;
import com.mysql.jdbc.Statement;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.TicketList;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.util.SQLConnectionPool;
import by.htp.easyfly.exception.*;

public class CreateTicketDaoImpl implements CreateTicketDao {
	Connection connection;

	@Override
	public int createTicket(Ticket ticket) throws DAOException {
		PreparedStatement ps;
		int key = 0;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {
			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ticket.getFlightId());
				ps.setInt(2, ticket.getPassengerId());
				ps.setString(3, convertAnswerToString(ticket.isPrimaryBoarding()));
				ps.setString(4, convertAnswerToString(ticket.isOnlineCheckIn()));
				ps.setDouble(5, ticket.getTotalAmount());
                ps.setInt(6, ticket.getUser().getUserId());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					// Retrieve the auto generated key(s).
					key = rs.getInt(1);
					System.out.println("id in sql " + key);
				}

				// ps.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method ticket(): " + e);
		}

		return key;
	}
/*
	@Override
	public int createTicketList(User user, int ticketId) throws DAOException {
		PreparedStatement ps;
		int key = 0;
		int maxTicketListId = 0;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

			if (!connection.isClosed()) {
				// multiply primary key, find max index
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_MAX_LIST);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					maxTicketListId += rs.getInt(1);
				}
				// insert into table
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_LIST, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, maxTicketListId);
				ps.setInt(2, ticketId);
				ps.setInt(3, user.getUserId());
				ps.executeUpdate();

				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					// Retrieve the auto generated key(s).
					key = rs.getInt(1);
					System.out.println("id in sql " + key);
				}
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method createTicketList(): " + e);
		}

		return key;
	}

	@Override
	public void updateUser(int userId, TicketList ticketList) throws DAOException {
		PreparedStatement ps;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_UPDATE_USER,
						Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ticketList.getTicketListId());
				ps.setInt(2, userId);
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("SQLException in method updateUser(): " + e);
		}
	}

	@Override
	public boolean ticketListExists(User user) throws DAOException {
		PreparedStatement ps;
		int flightListQuantity = 0;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_IF_TICKETLIST_EXISTS);
				ps.setInt(1, user.getUserId());
				// ps.executeUpdate();
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					flightListQuantity = rs.getInt(rs.getInt(1));
				}

			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method ticketListExists(): " + e);
		}
		if (flightListQuantity == 0)
			return false;
		else
			return true;
	}

	@Override
	public int searchTicketList(User user) throws DAOException {
		PreparedStatement ps;
		int ticketListId = 0;
		try (Connection connection = SQLConnectionPool.getDs().getConnection()) {

			if (!connection.isClosed()) {
				ps = connection.prepareStatement(SQL_STATEMENT_CREATE_TICKET_SEARCH_TICKET_LIST);
				ps.setInt(1, user.getUserId());
				// ps.executeUpdate();
				ResultSet rs = ps.executeQuery();
				// ticketListId =rs.getInt(rs.getInt(1));
				// ---------
				if (rs.next()) {
					ticketListId = rs.getInt(1);
					System.out.println("id in sql " + ticketListId);
				}
				// ---------

			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in method searchTicketList(): " + e);
		}
		return ticketListId;
	}*/

	private String convertAnswerToString(boolean expresion) {
		if (expresion)
			return "Yes";
		else
			return "No";
	}
}
