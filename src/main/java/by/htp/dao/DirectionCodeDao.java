package by.htp.dao;

import by.htp.bin.Direction;
import by.htp.exception.DAOException;

public interface DirectionCodeDao {
	String directionCode(String direction) throws DAOException;
}
