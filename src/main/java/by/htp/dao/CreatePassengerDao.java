package by.htp.dao;

import by.htp.bin.Passenger;
import by.htp.exception.DAOException;

public interface CreatePassengerDao {
	public int passenger(Passenger passenger) throws DAOException;

}
