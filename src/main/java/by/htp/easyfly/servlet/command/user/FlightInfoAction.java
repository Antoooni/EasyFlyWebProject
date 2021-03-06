package by.htp.easyfly.servlet.command.user;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SelectedFlightService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;
import by.htp.easyfly.util.DateTimeTransform;

public class FlightInfoAction implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(FlightInfoAction.class.getName());

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

				Flight flight = selectedFlightService.flight(flightId);
				request.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
				session.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
                int[] duration;
                duration= DateTimeTransform.duration(flight.getDepartureDate(),flight.getDepartureTime(),flight.getArrivalDate(),flight.getArrivalTime());
                request.setAttribute(REQUEST_PARAM_FLIGHT_DURATION, duration);
                session.setAttribute(REQUEST_PARAM_FLIGHT_DURATION, duration);

                System.out.println(flight.toString());
				request.setAttribute(REQUEST_PARAM_USER_LOGGED, true);
			} else {
				request.setAttribute(REQUEST_PARAM_USER_LOGGED, false);
				request.setAttribute(REQUEST_PARAM_FLIGHTS_LIST,
						session.getAttribute(REQUEST_PARAM_SESSION_FLIGHTLIST));
				page = PAGE_FLIGHT_LIST;
			}
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {
            LOG.error("Flight info error " + e);
		}
	}

}
