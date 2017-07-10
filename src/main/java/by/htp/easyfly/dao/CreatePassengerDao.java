package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Passenger;
import by.htp.easyfly.exception.DAOException;

public interface CreatePassengerDao {
	public int passenger(Passenger passenger) throws DAOException;

}
