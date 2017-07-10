package by.htp.service.Impl;

import by.htp.bin.Direction;
import by.htp.dao.DirectionCodeDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;
import by.htp.service.DirectionCodeService;

public class DirectionCodeServiceImpl implements DirectionCodeService {
	private DirectionCodeDao directionCode;
//	DaoFactory daoFactory = new DaoFactory();

	public DirectionCodeServiceImpl() {
		directionCode = DaoFactory.getInstance().getDirectionCodeDao();
	}

	@Override
	public String directionCode(String direction) throws ServiceException {
		try{
		return directionCode.directionCode(direction);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}


}
