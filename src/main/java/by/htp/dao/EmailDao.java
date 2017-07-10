package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.exception.DAOException;
import by.htp.bin.User;

import java.util.List;

public interface EmailDao {
    public List<User> selectUserEmail(Flight flight) throws DAOException;
}
