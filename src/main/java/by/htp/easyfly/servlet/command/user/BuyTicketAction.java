package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import java.sql.Date;
import java.util.HashMap;

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
		Ticket ticket = new Ticket();
		int ticketListId = 0;
		HttpSession session = request.getSession(true);
		try {
			session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
			Flight flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT);
			System.out.println("flight " + flight.getDepartureDate() + " " + flight.getFlightCode());

			// create passenger
			Passenger passenger = new Passenger();
			Baggage baggage = null;

			passenger.setName(request.getParameter(REQUEST_PARAM_PASSENGER_NAME));
			passenger.setSurname(request.getParameter(REQUEST_PARAM_PASSENGER_SURNAME));
			passenger.setMiddleName(request.getParameter(REQUEST_PARAM_PASSENGER_MIDNAME));
			passenger.setAge(Integer.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_AGE)));
			passenger.setDateOfBirth(request.getParameter(REQUEST_PARAM_PASSENGER_BIRTH));
			passenger.setSex(request.getParameter(REQUEST_PARAM_PASSENGER_SEX));
			passenger.setPassportId(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_NUMBER));
			passenger.setPassportExpiry(Date.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_PASSPORT_EXPIRTY)));
			passenger.setBaggage(Baggage.valueOf(request.getParameter(REQUEST_PARAM_PASSENGER_BAGGAGE).toUpperCase()));

			int passengerId = createPassengerService.passenger(passenger);
			System.out.println(passenger.toString());

			// create ticket
			ticket.setPassengerId(passengerId);
			ticket.setFlightId(flight.getFlightId());
			ticket.setPrimaryBoarding(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_PRIMARY_BOARDING)));
			ticket.setOnlineCheckIn(convertAnswer(request.getParameter(REQUEST_PARAM_TICKET_CHECKIN)));
			// ticket.setTotalAmount(request.getParameter());
			System.out.println(ticket.toString());
			int ticketId = createTicketService.ticket(ticket);

			User user = (User) session.getAttribute(REQUEST_PARAM_SESSION_USER);

			// check if ticket list is exists
			if (!createTicketService.ticketListExists(user)) { // ticket list
																// doesn't
																// exists

				// create ticket list
				ticketListId = createTicketService.createTicketList(user, ticketId);
				// update user
				HashMap<User, Flight> userFlightList = new HashMap<User, Flight>();
				userFlightList.put(user, flight);
				TicketList ticketList = new TicketList();
				ticketList.setTicketListId(ticketListId);
				ticketList.setFlight(userFlightList);
				createTicketService.updateUser(user.getUserId(), ticketList);

			} else { // ticket list already exists
				ticketListId = createTicketService.searchTicketList(user);
				// add ticket to licket List
			}
			// update user

			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

	private boolean convertAnswer(String s) {
		s.toUpperCase();
		if (s.equals("YES"))
			return true;
		else
			return false;
	}
}
