package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.bin.User;

import java.util.List;

public interface EmailChangedFlightDao {
    public List<User> selectUserChangedFlight(Flight flight) throws DAOException;
}
