package by.htp.easyfly.service.Impl;

import by.htp.easyfly.dao.DirectionCodeDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.DirectionCodeService;

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
