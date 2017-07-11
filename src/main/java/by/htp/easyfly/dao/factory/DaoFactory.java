package by.htp.easyfly.dao.factory;

import by.htp.easyfly.dao.*;
import by.htp.easyfly.dao.Impl.*;

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
    private final static EmailChangedFlightDao emailChangedFlightDao = new EmailChangedFlightDaoImpl();
	

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
    public EmailChangedFlightDao getEmailChangedFlightDao() {
        return emailChangedFlightDao;
    }
}
