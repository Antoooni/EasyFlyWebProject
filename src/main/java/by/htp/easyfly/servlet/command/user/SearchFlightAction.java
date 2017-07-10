package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.service.DirectionCodeService;
import by.htp.easyfly.service.FlightListService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

public class SearchFlightAction implements CommandAction {
	// ServiceFactory serviceFactory = new ServiceFactory();

	private FlightListService flightListService;
	private DirectionCodeService rirectionCodeService;

	public SearchFlightAction() {
		flightListService = ServiceFactory.getInstance().getFlightListService();
		rirectionCodeService = ServiceFactory.getInstance().getDirectionCodeService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		String page = request.getParameter(PAGE_FLIGHT_LIST);
		String departureCity = request.getParameter(REQUEST_PARAM_DIRECTION_FROM);
		String arrivalCity = request.getParameter(REQUEST_PARAM_DIRECTION_TO);
		String departureDateSQL = request.getParameter(REQUEST_PARAM_DEPARTURE_DATE);
		String arrivalDateSQL = request.getParameter(REQUEST_PARAM_ARRIVAL_DATE);
		// String userRole=request.getParameter(REQUEST_PARAM_SESSION_USERNAME);

		try {
			String departureCode = null;
			String arrivalCode = null;
			departureCode = rirectionCodeService.directionCode(departureCity); // convert
																				// departure
																				// city
																				// to
																				// airport
																				// code
			arrivalCode = rirectionCodeService.directionCode(arrivalCity); // convert
																			// arrival
																			// city
																			// to
																			// airport
																			// code

			List<Flight> listFlight = flightListService.flightList(departureCode, arrivalCode, departureDateSQL,
					arrivalDateSQL);

			request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST, listFlight);
			session.setAttribute(REQUEST_PARAM_SESSION_FLIGHTLIST, listFlight);
			User user = (User) session.getAttribute(REQUEST_PARAM_SESSION_USER);
			if (user == null) {
				page = PAGE_FLIGHT_LIST;
			} else if (user.getRole() == null) {
				page = PAGE_FLIGHT_LIST;
			} else
				page = PAGE_FLIGHT_LIST_CHANGING;
			page = PAGE_NO_FLIGHTS_ERROR;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG, "error temp");
			ForwardPage.forwardPage(request, response, page);
		} catch (Exception e) {
		}
	}

}
