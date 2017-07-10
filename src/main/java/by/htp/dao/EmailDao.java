package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.exception.DAOException;
import by.htp.bin.User;

import java.util.List;

/**
 * Created by Ayumazec on 07.07.2017.
 */
public interface EmailDao {
    public List<User> selectUserEmail(Flight flight) throws DAOException;
}
