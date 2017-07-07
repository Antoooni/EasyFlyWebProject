package by.htp.dao.factory;

import by.htp.dao.ChangeFlightDao;
import by.htp.dao.ChangeFlightDaoImpl;
import by.htp.dao.CreatePassengerDao;
import by.htp.dao.CreatePassengerDaoImpl;
import by.htp.dao.CreateTicketDao;
import by.htp.dao.CreateTicketDaoImpl;
import by.htp.dao.DirectionCodeDao;
import by.htp.dao.DirectionCodeDaoImpl;
import by.htp.dao.FlightDirectionDao;
import by.htp.dao.FlightDirectionDaoImpl;
import by.htp.dao.FlightListDao;
import by.htp.dao.FlightListDaoImpl;
import by.htp.dao.SelectedFlightDao;
import by.htp.dao.SelectedFlightDaoImpl;
import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.UserAuthorizationDaoImpl;
import by.htp.dao.UserCreateDao;
import by.htp.dao.UserCreateDaoImpl;

public class DaoFactory {
	private final static UserAuthorizationDao userAuthorizationDao = new UserAuthorizationDaoImpl();
	private final static FlightDirectionDao flightDirectionDao = new FlightDirectionDaoImpl();
	private final static FlightListDao flightListDao = new FlightListDaoImpl();
	private final static DirectionCodeDao directionCodeDao = new DirectionCodeDaoImpl();
	private final static UserCreateDao userCreateDao = new UserCreateDaoImpl();
	private final static SelectedFlightDao selectedFlightDao = new SelectedFlightDaoImpl();
	private final static CreatePassengerDao createPassengerDao = new CreatePassengerDaoImpl();
	private final static CreateTicketDao createTicketDao = new CreateTicketDaoImpl();
	private final static ChangeFlightDao changeFlightDao = new ChangeFlightDaoImpl();
	

	private DaoFactory() {

	}

	private static class DaoFactoryHolder {
		private final static DaoFactory instance = new DaoFactory();
	}

	public static DaoFactory getInstance() {
		return DaoFactoryHolder.instance;
	}

	public UserAuthorizationDao getUserAuthorizationDao() {
		return userAuthorizationDao;
	}
	public FlightDirectionDao getFlightDirectionDao(){
		return flightDirectionDao;
	}
	public FlightListDao getFlightListDao(){
		return flightListDao;
	}
	
	public DirectionCodeDao getDirectionCodeDao(){
		return directionCodeDao;
	}
	public UserCreateDao getUserCreateDao(){
		return userCreateDao;
	}
	public SelectedFlightDao getSelectedFlightDao(){
		return selectedFlightDao;
	}
	public CreatePassengerDao getCreatePassengerDao(){
		return createPassengerDao;
	}
	public CreateTicketDao getCreateTicketDao(){
		return createTicketDao;
	}
	public ChangeFlightDao getChangeFlightDao(){
		return changeFlightDao;
	}
}
