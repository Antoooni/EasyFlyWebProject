package by.htp.easyfly.dao;

import by.htp.easyfly.exception.DAOException;

public interface DirectionCodeDao {
	String directionCode(String direction) throws DAOException;
}
