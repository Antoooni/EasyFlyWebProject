package by.htp.easyfly.service.factory;

import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.service.*;
import by.htp.easyfly.service.Impl.*;

public class ServiceFactory {

	private static final AuthorizationService authorizationService=new AuthorizationServiceImpl();
	private static final DirectionService directionService= new DirectionServiceImpl();
	private static final DirectionCodeService directionCodeService = new DirectionCodeServiceImpl();
	private static final UserCreateService userCreateService = new UserCreateServiceImpl( DaoFactory.getInstance().getUserCreateDao());
	private static final FlightListService flightListService = new FlightListServiceImpl();
	private static final SelectedFlightService selectedFlightService = new SelectedFlightServiceImpl(DaoFactory.getInstance().getSelectedFlightDao());
	private static final CreatePassengerService createPassengerService = new CreatePassengerServiceImpl();
	private static final CreateTicketService createTicketService = new CreateTicketServiceImpl();
	private static final ChangeFlightService changeFlightService = new ChangeFlightServiceImpl();
    private static final SearchChangedFlightService searchChangedFlightService = new SearchChangedFlightServiceImpl();
    private static final SendEmailService sendEmailService =new EmailServiceImpl();

	private ServiceFactory() { 

	}

	private static class ServiceFactoryHolder {
		private final static ServiceFactory instance = new ServiceFactory();
	}

	public static ServiceFactory getInstance() {
		return ServiceFactoryHolder.instance;
	}
	public DirectionService getDirectionService() {
		return directionService;
	}
	public AuthorizationService getAuthorizationService() {
		return authorizationService;
	}
	public DirectionCodeService getDirectionCodeService() {
		return directionCodeService;
	}
	public UserCreateService getUserCreateService() {
		return userCreateService;
	}
	public FlightListService getFlightListService() {
		return flightListService;
	}
	public SelectedFlightService getSelectedFlightService() {
		return selectedFlightService;
	}
	public CreatePassengerService getCreatePassengerService(){
		return createPassengerService;
	}
	public CreateTicketService getCreateTicketService(){
		return createTicketService;
	}
	public ChangeFlightService getChangeFlightService(){
		return changeFlightService;
	}
    public SendEmailService getSendEmailService(){
        return sendEmailService;
    }
    public SearchChangedFlightService getSearchChangedFlightService() {
        return searchChangedFlightService;
    }
}
