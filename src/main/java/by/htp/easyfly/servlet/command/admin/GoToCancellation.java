package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SelectedFlightService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class GoToCancellation implements CommandAction {

	private SelectedFlightService selectedFlightService;

	public GoToCancellation() {

		selectedFlightService = ServiceFactory.getInstance().getSelectedFlightService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_CANCELLATION;
		HttpSession session = request.getSession(true);
		try {
			int flightId = Integer.valueOf(request.getParameter(REQUEST_PARAM_SELECTED_FLIGHT_ID));
			System.out.println("Selected changed flight ID: " + flightId);

			Flight flight = selectedFlightService.flight(flightId);
			request.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
			session.setAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO, flight);

			System.out.println(flight.toString());
			request.setAttribute(REQUEST_PARAM_USER_LOGGED, true);
			System.out.println("ADMIN LOGGED");
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
