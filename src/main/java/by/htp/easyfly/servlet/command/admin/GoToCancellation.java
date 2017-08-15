package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SelectedFlightService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.util.DateTimeTransform;
import by.htp.easyfly.util.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToCancellation implements CommandAction {
    private static final Logger LOG = LogManager.getLogger(GoToCancellation.class.getName());
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

			Flight flight = selectedFlightService.flight(flightId);
			request.setAttribute(REQUEST_PARAM_FLIGHT_INFO, flight);
			session.setAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO, flight);
            //get flight duration
            int[] duration;
            duration= DateTimeTransform.duration(flight.getDepartureDate(), flight.getDepartureTime(), flight.getArrivalDate(), flight.getArrivalTime());
            request.setAttribute(REQUEST_PARAM_FLIGHT_DURATION, duration);
            session.setAttribute(REQUEST_PARAM_FLIGHT_DURATION, duration);

			System.out.println(flight.toString());
			request.setAttribute(REQUEST_PARAM_USER_LOGGED, true);
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {
            LOG.error("Select flight error " + e);
        }
	}

}
