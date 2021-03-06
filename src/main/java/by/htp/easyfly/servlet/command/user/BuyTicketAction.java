package by.htp.easyfly.servlet.command.user;

import by.htp.easyfly.bin.*;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.CreatePassengerService;
import by.htp.easyfly.service.CreateTicketService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.util.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.htp.easyfly.util.ConstantValue.*;

public class BuyTicketAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(BuyTicketAction.class.getName());

	private CreatePassengerService createPassengerService;
	private CreateTicketService createTicketService;

	public BuyTicketAction() {
		createPassengerService = ServiceFactory.getInstance().getCreatePassengerService();
		createTicketService = ServiceFactory.getInstance().getCreateTicketService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_DONE;
		HttpSession session = request.getSession(true);
        Passenger passenger = new Passenger();
        Ticket ticket = new Ticket();
        session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
        Flight flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
		try {
            //initialization passenger fields
            passenger = initPassengerFields(request, passenger);
            //check if fields are correct
            if(InputDataValidator.isValidPassenger(passenger.getName(), passenger.getSurname(), passenger.getAge(), passenger.getPassportId())) {
                // create passenger
                passenger.setPassengerId(createPassengerService.passenger(passenger));
                LOG.info("Passenger "+passenger.getPassengerId()+" was created");
                // create ticket
                ticket = initTicketFields(request, flight, passenger.getPassengerId(), ticket, session);
                createTicketService.createTicket(ticket);
                LOG.info("Ticket was purchased!");
                ForwardPage.forwardPage(request, response, page);
            }
            else if(!InputDataValidator.isBirthdayBeforeDeparture(flight.getDepartureDate(), passenger.getDateOfBirth())){
                page = PAGE_FLIGHT_INFO;
                request.setAttribute(ERROR_BIRTHDAY_DATE, INVALID_BIRTHDAY_DATE);
                ForwardPage.forwardPage(request, response, page);
            }
            else if(!InputDataValidator.isExpiryBeforeArrival(flight.getArrivalDate(), passenger.getPassportExpiry())){
                page = PAGE_FLIGHT_INFO;
                request.setAttribute(ERROR_EXPIRY_DATE, INVALID_EXPIRY_DATE);
                ForwardPage.forwardPage(request, response, page);
            }
            else{
                page = PAGE_FLIGHT_INFO;
                request.setAttribute(ERROR_INPUT, INVALID_INPUT);
                session.setAttribute(ERROR_INPUT, INVALID_INPUT);
                LOG.info("Ticket was not purchased");
                ForwardPage.forwardPage(request, response, page);
            }
		} catch (ServiceException e) {
            LOG.error("Buy ticket action error " + e);
		}
	}

	private boolean convertAnswer(String s) {
		String upperS =s.toUpperCase();
        return upperS.equals("YES");
	}
    private Passenger initPassengerFields(HttpServletRequest request, Passenger passenger){
        passenger.setName(request.getParameter(REQUEST_PARAM_PASSENGER_NAME));
        passenger.setSurname(request.getParameter(REQUEST_PARAM_PASSENGER_SURNAME));
        passenger.setMiddleName(request.getParameter(REQUEST_PARAM_PASSENGER_MIDNAME));
        passenger.setAge(Integer.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_AGE)));
        passenger.setDateOfBirth(DateTimeTransform.convertDate(request.getParameter(REQUEST_PARAM_PASSENGER_BIRTH)));
        passenger.setSex(request.getParameter(REQUEST_PARAM_PASSENGER_SEX));
        passenger.setPassportId(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER));
        passenger.setPassportExpiry(DateTimeTransform.convertDate(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRY)));
        passenger.setBaggage(Baggage.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_BAGGAGE).toUpperCase()));
        passenger.setEmail(request.getParameter(REQUEST_PARAM_PASSENGER_EMAIL));
        return passenger;
    }
    private Ticket initTicketFields(HttpServletRequest request, Flight flight, int passengerId,Ticket ticket, HttpSession session){
        ticket.setPassengerId(passengerId);
        ticket.setFlightId(flight.getFlightId());
        ticket.setPrimaryBoarding(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_PRIMARY_BOARDING)));
        ticket.setOnlineCheckIn(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_CHECKIN)));
        ticket.setUser((User) session.getAttribute(REQUEST_PARAM_SESSION_USER));
        return ticket;
    }

}
