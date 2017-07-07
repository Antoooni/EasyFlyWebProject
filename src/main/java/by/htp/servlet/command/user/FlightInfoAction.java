package by.htp.servlet.command.user;

import static by.htp.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.Flight;
import by.htp.exception.ServiceException;
import by.htp.service.SelectedFlightService;
import by.htp.service.factory.ServiceFactory;
import by.htp.servlet.ForwardPage;
import by.htp.servlet.command.CommandAction;

public class FlightInfoAction implements CommandAction {

	// private ServiceFactory serviceFactory = new ServiceFactory();

	private SelectedFlightService selectedFlightService;

	public FlightInfoAction() {
		selectedFlightService = ServiceFactory.getInstance().getSelectedFlightService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_FLIGHT_INFO;
		HttpSession session = request.getSession(true);
		try {
			if (session.getAttribute(REQUEST_PARAM_SESSION_USER) != null) {
				int flightId = Integer.valueOf(request.getParameter(REQUEST_PARAM_SELECTED_FLIGHT_ID));
				System.out.println("Selected flight ID: " + flightId);

				Flight flight = selectedFlightService.flight(flightId);
				request.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
				session.setAttribute("flight", flight);

				System.out.println(flight.toString());
				request.setAttribute(REQUEST_PARAM_USER_LOGGED, true);
				System.out.println("LOGGED");
			} else {
				request.setAttribute(REQUEST_PARAM_USER_LOGGED, false);
				request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST,
						session.getAttribute(REQUEST_PARAM_SESSION_FLIGHTLIST));
				page = PAGE_FLIGHT_LIST;
				System.out.println("NON LOGGED");
			}
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
