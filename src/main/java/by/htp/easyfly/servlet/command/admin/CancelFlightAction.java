package by.htp.easyfly.servlet.command.admin;

import static by.htp.easyfly.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.ChangeFlightService;
import by.htp.easyfly.service.factory.ServiceFactory;
import by.htp.easyfly.servlet.ForwardPage;
import by.htp.easyfly.servlet.command.CommandAction;

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
