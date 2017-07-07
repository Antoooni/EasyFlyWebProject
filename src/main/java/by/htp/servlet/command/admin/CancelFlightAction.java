package by.htp.servlet.command.admin;

import static by.htp.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.Flight;
import by.htp.exception.ServiceException;
import by.htp.service.ChangeFlightService;
import by.htp.service.factory.ServiceFactory;
import by.htp.servlet.ForwardPage;
import by.htp.servlet.command.CommandAction;

public class CancelFlightAction implements CommandAction {
	private ChangeFlightService changeFlightService;

	public CancelFlightAction() {
		changeFlightService = ServiceFactory.getInstance().getChangeFlightService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Flight flight = new Flight();
		try {
			flight = (Flight) session.getAttribute(REQUEST_PARAM_SESSION_FLIGHT_CHANGING_INFO);
			changeFlightService.cancelFlight(flight);
			String page = PAGE_DONE_CANCELLATION;
			ForwardPage.forwardPage(request, response, page);
		} catch (ServiceException e) {

		}
	}

}
