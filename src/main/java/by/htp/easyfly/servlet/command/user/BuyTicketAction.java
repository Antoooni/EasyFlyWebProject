package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Baggage;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.Passenger;
import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.TicketList;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.CreatePassengerService;
import by.htp.easyfly.service.CreateTicketService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class BuyTicketAction implements CommandAction {
	// ServiceFactory serviceFactory = new ServiceFactory();

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
		try {
			session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
			Flight flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
			System.out.println("flight " + flight.getDepartureDate() + " " + flight.getFlightCode());

			// create passenger
			Passenger passenger = new Passenger();
            passenger = initPassengerFields(request, passenger);

//			int passengerId = createPassengerService.passenger(passenger);
            //get created passenger id
            passenger.setPassengerId(createPassengerService.passenger(passenger));
			System.out.println(passenger.toString());

			// create ticket
            Ticket ticket = new Ticket();
            ticket = initTicketFields(request,  flight,  passenger.getPassengerId(), ticket, session );
			// ticket.setTotalAmount(request.getParameter());
			System.out.println(ticket.toString());
			int ticketId = createTicketService.createTicket(ticket);

			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

	private boolean convertAnswer(String s) {
		s.toUpperCase();
        return s.equals("YES");
	}
    private Passenger initPassengerFields(HttpServletRequest request, Passenger passenger){
        passenger.setName(request.getParameter(REQUEST_PARAM_PASSENGER_NAME));
        passenger.setSurname(request.getParameter(REQUEST_PARAM_PASSENGER_SURNAME));
        passenger.setMiddleName(request.getParameter(REQUEST_PARAM_PASSENGER_MIDNAME));
        passenger.setAge(Integer.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_AGE)));
        passenger.setDateOfBirth(request.getParameter(REQUEST_PARAM_PASSENGER_BIRTH));
        passenger.setSex(request.getParameter(REQUEST_PARAM_PASSENGER_SEX));
        passenger.setPassportId(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER));
        passenger.setPassportExpiry(Date.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRTY)));
        passenger.setBaggage(Baggage.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_BAGGAGE).toUpperCase()));
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
